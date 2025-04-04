package Ch21;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import com.mysql.cj.jdbc.MysqlXADataSource;



public class C09분산Tx {
	
	public static void main(String[] args) throws Exception{
		// 트랜잭션은 기본적으로 단일 Connection 에서 여러 Sql처리시 Tx 설정할 수있다
		// 만약 여러 Connection 에서 각기 다른 sql문을 사용할 때 분산된 여러 Connection
		// 의 sql을 하나의 트랜잭션으로 묶어주어야한다
		
		// 앱, 웹 등 : 보통은 다중 접속 상황
		// 한 기능 안에 여러 DB 연결 상황 - 다중 connection 상황
		// -> 분산되어 있는 상황에서도 하나로 묶어 관리 : 분산 트랜젝션

		
        // 첫 번째 DB1에 대한 XADataSource 설정 : 2 phase commit 을 통한 분산 트랜잭션 처리를 위한 표준
        MysqlXADataSource xaDataSource1 = new MysqlXADataSource();
        xaDataSource1.setUrl("jdbc:mysql://localhost:3306/bookdb");
        xaDataSource1.setUser("root");
        xaDataSource1.setPassword("1234");
        
        // 두 번째 DB2에 대한 XADataSource 설정 : 2 phase commit 을 통한 분산 트랜잭션 처리를 위한 표준
        MysqlXADataSource xaDataSource2 = new MysqlXADataSource();
        xaDataSource2.setUrl("jdbc:mysql://localhost:3306/testdb");
        xaDataSource2.setUser("root");
        xaDataSource2.setPassword("1234");
        
        //------------------------------------
        // XAConnection 및 Connection 가져오기
        //------------------------------------
        XAConnection xaConnection1 = xaDataSource1.getXAConnection();
        Connection conn1 = xaConnection1.getConnection();
        XAResource xaResource1 = xaConnection1.getXAResource();

        XAConnection xaConnection2 = xaDataSource2.getXAConnection();
        Connection conn2 = xaConnection2.getConnection();
        XAResource xaResource2 = xaConnection2.getXAResource();
        
        // 트랜잭션 식별자 (XID) 생성 - 커넥션을 구별하기 위한 id
        Xid xid1 = createXid(100, 1); // 첫 번째 DB용 XID	(100 branchId , 1 GlobalId)
        Xid xid2 = createXid(100, 2); // 두 번째 DB용 XID (100 branchId , 2 GlobalId)

        
        try {
            // 첫 번째 DB 트랜잭션 시작
            xaResource1.start(xid1, XAResource.TMNOFLAGS);
            PreparedStatement pstmt1 = conn1.prepareStatement("insert into tbl_user values('a','1')");
            pstmt1.executeUpdate();
            PreparedStatement pstmt2 = conn1.prepareStatement("insert into tbl_user values('b','1')");
            pstmt2.executeUpdate();
            PreparedStatement pstmt3 = conn1.prepareStatement("insert into tbl_user values('c','1')");
            pstmt3.executeUpdate();
            xaResource1.end(xid1, XAResource.TMSUCCESS);
            

            // 두 번째 DB 트랜잭션 시작
            xaResource2.start(xid2, XAResource.TMNOFLAGS);
            PreparedStatement pstmt4 = conn2.prepareStatement("INSERT INTO tbl_std values('a','1','a')");
            pstmt4.executeUpdate();
            PreparedStatement pstmt5 = conn2.prepareStatement("INSERT INTO tbl_std values('a','2','b')"); // PK 오류 발생
            pstmt5.executeUpdate();
            PreparedStatement pstmt6 = conn2.prepareStatement("INSERT INTO tbl_std values('c','2','c')");
            pstmt6.executeUpdate();
            xaResource2.end(xid2, XAResource.TMSUCCESS);

            // 2-Phase Commit 준비
            int prepare1 = xaResource1.prepare(xid1);
            int prepare2 = xaResource2.prepare(xid2);

            // 커밋	- 두 커밋 동시 실행
            if (prepare1 == XAResource.XA_OK && prepare2 == XAResource.XA_OK) {
                xaResource1.commit(xid1, false);
                xaResource2.commit(xid2, false);
                System.out.println("Transaction committed successfully.");
            } else {
                throw new Exception("Prepare failed for one or both databases.");
            }

        } catch (Exception e) {
            // 롤백
            xaResource1.rollback(xid1);
            xaResource2.rollback(xid2);
            System.out.println("Transaction rolled back due to an error.");
            e.printStackTrace();
        } finally {
            // 자원 해제
            conn1.close();
            conn2.close();
            xaConnection1.close();
            xaConnection2.close();
        }
        //-----------
        
		
	}
	
	//----------------------------
    private static Xid createXid(int bid, int tid) {
        return new Xid() {
            private int formatId = 1;
            private byte[] branchQualifier = new byte[] { (byte) tid };
            private byte[] globalTransactionId = new byte[] { (byte) bid };

            @Override
            public int getFormatId() {
                return formatId;
            }

            @Override
            public byte[] getBranchQualifier() {
                return branchQualifier;
            }

            @Override
            public byte[] getGlobalTransactionId() {
                return globalTransactionId;
            }
        };
        
    }
    
}	

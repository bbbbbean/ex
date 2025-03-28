package Ch21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class Memo{
	
	private int id;
	private String text;
	private LocalDateTime createdAt;
	
	// 디폴트 생성자
	Memo(){}
	
	// 모든 인자 생성자
	public Memo(int id, String text, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
	}

	// toString
	@Override
	public String toString() {
		return "Memo [id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

class SelectFrame extends JFrame implements MouseListener,ActionListener{
	// Select 창 - 서브 창
	// 내용 전달 등 역할이 있음 -> 클래스로 만들어 빼기
	
	// C07GUI를 받을 참조변수
	C07GUI mainUi;
	
	// 조회 값을 표시할 테이블 생성
	JTable table;
	
	// 테이블 값이 많아질 때 대비
	JScrollPane scroll;
	
	// 패널
	JPanel panel;
	
	String selectedText;
	JButton btn1;
	
	// C07GUI와 상호작용 해야하니까 연결
	SelectFrame(C07GUI mainUi){
		super("SELECT 결과");
		this.mainUi = mainUi;
		
		setBounds(100,100,520,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 해당 창만 제거 옵션 : DISPOSE_ON_CLOSE
		
		setVisible(false);	// select 버튼을 누르면 창이 뜨도록 설정할 예정
		
		// panel
		panel = new JPanel();
		panel.setLayout(null);
		
		// 버튼 설정
		btn1 = new JButton("가져오기");
		btn1.setBounds(420,10,70,30);
		btn1.addActionListener(this);
		
		panel.add(btn1);
		
		// frame(panel) - 상단에서 패널 생성 후 프레임과 연결
		add(panel);
		
		// event
		
		
		
	}
	
	// select 프레임 생성 후 버튼을 누르면 조회 진행
	void select(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		if(scroll!=null) scroll = null;
		
		// 버튼 눌렀을 때 테이블 생성
		// component - 테이블 생성
		String [] columns = {"ID","TEXT","CREATED_AT"};
//		String [][] data = {
//				{"1","A","2025-03-17"}	// 샘플 데이터
//		}; -> 리스트 스트링 형태 배열로 전환
		List<String[]>data = new ArrayList();	// 동적 확장을 위해 컬렉션을 써서 배열 단위로 데이터를 받아낸 다음 2차원으로 변환**
		// 변환은 DB값이 들어 온 뒤 가능 -> 내용 받아온 뒤로 변환 위치 이동
		
		// 전체 조회 가져와서 console에 출력
		try {
			// sql 준비
			pstmt = conn.prepareStatement("select * from tbl_memo");
						
			// sql 실행
			List<Memo> list = new ArrayList();
			Memo memo;
			rs = pstmt.executeQuery();
						
			if(rs != null) {
				while(rs.next()) {
//					System.out.print(rs.getInt("id")+" ");
//					System.out.print(rs.getString("text")+" ");
//					System.out.print(rs.getTime("createdAt")+"\n");
//					System.out.print(rs.getTimestamp("createdAt")+"\n");
								
					memo = new Memo();
					memo.setId(rs.getInt("id"));
					memo.setText(rs.getString("text"));
					Timestamp timestamp = rs.getTimestamp("createdAt");
					memo.setCreatedAt(timestamp.toLocalDateTime());	// DB와 JAVA의 시간 포맷이 다름 -> 적절한 포매팅 작업이 필요 / 타임스탬프 이용
					list.add(memo);
					
					// String 형으로 data 삽입 -> String[] 형태라..
					data.add(new String[] {rs.getString("id"),rs.getString("text"),rs.getString("createdAt")});
				}
			}
			list.forEach(System.out::println);
			
			// **2차원으로 변환 / 위치 이동
			String[][] arr = new String[data.size()][];	// 행의 갯수를 리스트의 갯수로 받기
			// for문으로 값 복사
			for(int i=0; i<data.size();i++) {
				arr[i] = data.get(i);
			}
			
			
			table = new JTable(arr, columns);	// 2차원 배열 형태 지키며 삽입
			// table에 이벤트 추가
			table.addMouseListener(this);
//			table.setBounds(10, 10, 400, 400);
					
			scroll = new JScrollPane(table);
			scroll.setBounds(10, 10, 400, 400);
					
			// panel(component) - 테이블과 패널 연결
//			panel.add(table);
			panel.add(scroll);
						
		} catch (SQLException e1) {e1.printStackTrace();}finally {
			try{rs.close();}catch(Exception e2) {}
			try{pstmt.close();}catch(Exception e2) {}
		}	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 테이블 행 클릭 가능해짐
		// 어떤 행 클릭했는지 그 위치에 대한 데이터 받아오기
		int selectedRow = table.getSelectedRow();
		selectedText = table.getValueAt(selectedRow, 1).toString();	// 변수화
		System.out.println("Click"+selectedText);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			// mainUI에 selectedText를 전달
			mainUi.area1.setText(selectedText);
			// 전달 후 현재 프레임 종료 처리를 원하면 dispose 사용
//			dispose();
			
		}
	}
	
}

class C07GUI extends JFrame implements ActionListener,KeyListener,MouseListener{	// ActionListener 이벤트 추가를 위함
	
	// 이벤트 처리를 위해 각 버튼을 특정할 수 있도록 멤버 변수로 전환
	JButton btn1;
	JButton btn2;
	JButton btn3;	// insert
	JButton btn4;	// update
	JButton btn5;	// delete
	JButton btn6;	// select one
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";
		
	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	// SELECT FRAME
	// 본체(C07GUI)와 서브(SELECT)가 함께 뜨게 설정
	SelectFrame selectFrame;
	
	
	
	public C07GUI(String title) throws Exception {
		super(title);
		
		setBounds(100,100,467,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기 시 프로세스 종료
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// 버튼 설정
		btn1 = new JButton("저장하기"); 
		btn2 = new JButton("불러오기"); 
		btn3 = new JButton("INSERT"); 
		btn4 = new JButton("UPDATE"); 
		btn5 = new JButton("DELETE"); 
		btn6 = new JButton("SELECT"); 
		input = new JButton("입력");
		
		btn1.setBounds(320,10,120,30);
		btn2.setBounds(320,50,120,30);
		btn3.setBounds(320,90,120,30);
		btn4.setBounds(320,130,120,30);
		btn5.setBounds(320,170,120,30);
		btn6.setBounds(320,210,120,30);
		input.setBounds(320,520,120,40);
		
		// 텍스트 영역 설정
		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,10,300,500);
		
		// 텍스트 입력 설정
		txt1 = new JTextField();
		txt1.setBounds(10,520,300,40);
		
		
		// event listener add
		// 각 버튼을 구별하려면? 해당 버튼임을 알리는 상태 전송 -> 이름 전송
		// 멤버 변수로 올려야 함수 바깥에서도 확인 가능
		btn1.addActionListener(this);	// btn1 상태 전송
		btn2.addActionListener(this);	// btn2 상태 전송
		btn3.addActionListener(this);	// btn3 상태 전송
		btn4.addActionListener(this);	// btn4 상태 전송
		btn5.addActionListener(this);	// btn5 상태 전송
		btn6.addActionListener(this);	// btn6 상태 전송
		input.addActionListener(this);	// input 상태 전송
		txt1.addKeyListener(this);
		area1.addMouseListener(this);
		
		
		// 패널에 연결
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(input);
		panel.add(scroll1);
		panel.add(txt1);
		
		// 프레임에 패널 연결
		add(panel);
		
		// 창 보이게 설정
		setVisible(true);
		
		// DB conn
		// DRIVER 메모리 적재
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success");
					
		// DB연결
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB Connected");
		
		// SELECT FRAME 연결
		// SELECT FRAME과 상호작용 해야하니까 연결
		selectFrame = new SelectFrame(this);	// this == C07GUI
	}
	
	

	// 이벤트 설정
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭");
		if(e.getSource()==btn1) {	
			System.out.println("저장하기");
			String contents = area1.getText();
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST\\");
			if(defaultDirPath.exists()) { // 기본 경로가 존재한다면
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			
			// 파일 탐색기 화면에 보이게 하는 작업 - null값을 주면 기본 형태로 파일이 열림
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : "+selectedVal);	// 메뉴 선택에 따라 selectedVal값이 달라짐 취소 : 1 저장 : 0
			
			if(selectedVal == JFileChooser.APPROVE_OPTION) { // 저장을 눌렀다면
				// 선택한 파일을 불러오기
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+selectedFile);
				
				// 파일 확장자 추가
				String filePath = selectedFile.toString();
				if(!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString()+".txt";
				}
				System.out.println("filePath : "+filePath);
				
				// 파일 기본 저장 이름 잡기 -> 위에서 다른이름저장 작업함.. 주석처리
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//				String filename = LocalDateTime.now().format(formatter);
				Writer out = null;
				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					try {out.close();} catch (IOException e1) {e1.printStackTrace();}
				}
			}
			
//			// 고정 경로 잡기
//			String dirPath = "C:\\IOTEST\\";
			
			
			
		}else if(e.getSource()==btn2) {	
			System.out.println("불러오기");
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("불러 올 파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						
			File defaultDirPath = new File("C:\\IOTEST\\");
			if(defaultDirPath.exists()) { // 기본 경로가 존재한다면
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
						
			// 파일 탐색기 화면에 보이게 하는 작업 - null값을 주면 기본 형태로 파일이 열림
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : "+selectedVal);	// 메뉴 선택에 따라 selectedVal값이 달라짐 취소 : 1 저장 : 0
			
			if(selectedVal == JFileChooser.APPROVE_OPTION) {
				// 선택한 파일을 불러오기
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+selectedFile);
				
				try {
					Reader fin = new FileReader(selectedFile.toString());
					StringBuffer buffer = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data==-1) break;
						buffer.append((char)data);
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
					
				}catch(Exception e1) {e1.printStackTrace();}
			}
			
		}else if(e.getSource()==btn3) {	
			System.out.println("INSERT");
			try {
				pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,now())");
				pstmt.setString(1,area1.getText());
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("insert 성공");
//					JOptionPane.showMessageDialog(null,"내용","창제목","ICON VAL");
					JOptionPane.showMessageDialog(null,"Insert 성공","Insert 확인창",JOptionPane.INFORMATION_MESSAGE);
				}else {
					System.out.println("insert 실패");
					JOptionPane.showMessageDialog(null,"Insert 실패","Insert 확인창",JOptionPane.ERROR_MESSAGE);
				}
					
			
			} catch (SQLException e1) {e1.printStackTrace();}
			finally {
				try {pstmt.close();}catch(Exception e1) {e1.printStackTrace();}
			}
			
		}else if(e.getSource()==btn4) {	
			System.out.println("UPDATE");
			
		}else if(e.getSource()==btn5) {	
			System.out.println("DELETE");
			
		}else if(e.getSource()==btn6) {	
			// 버튼 누르면 Ui창이 뜨게 설정
			selectFrame.setVisible(true);
			
			// 전체 조회 가져와서 Console에 출력
			selectFrame.select(conn, pstmt, rs);
			
			
		}else{	
			System.out.println("입력");
		}
	}

	
	
	// 키보드
	@Override
	public void keyTyped(KeyEvent e) {
		// 한글 문자 인식
//		System.out.println("keyTyped"+e.getKeyChar());
//		System.out.println("keyTyped"+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 한글 문자 인식 못함
//		System.out.println("keyPressed"+e.getKeyChar());
//		System.out.println("keyPressed"+e.getKeyCode());	// 엔터 == 10
		if(e.getSource()==txt1) {
			if(e.getKeyCode()==10) { // 엔터를 입력했다면
				String message = txt1.getText();	// 입력된 텍스트 들고오기
				System.out.println(message);
				area1.append(message+"\n");
				txt1.setText("");	// text 초기화
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 한글도 영어로 인식함
//		System.out.println("keyReleased"+e.getKeyChar());
//		System.out.println("keyReleased"+e.getKeyCode());
		
	}

	
	
	// 마우스
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
//			System.out.println("클릭"+e.getPoint());	// x,y축에 대한 상대적 정보 제공
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("offset : "+offset);
			int row = area1.getLineOfOffset(offset); // 몇번째 행인지 확인 가능
//			System.out.println("row : "+row);
			
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n",startOffset,endOffset);
			
			String str = area1.getText(startOffset,endOffset-startOffset); // endOffset-startOffset 문장 길이
			System.out.println(str);
			
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}


public class C07SwingAddDBMain {

	public static void main(String[] args) throws Exception {
		
		new C07GUI("Chatting Server");
		
	}

}

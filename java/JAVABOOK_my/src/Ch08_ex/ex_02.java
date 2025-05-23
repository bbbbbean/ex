package Ch08_ex;


// 홍길동이 사과 장수에게 사과를 구매한다
// 홍길동(고객) 	-  	사과장수(판매자) - 객체
// 보유 금액(속성)		보유 금액(속성)
// 사과 개수(속성)		사과 개수(속성)
//					개당 가격(속성)

// 구매하기 (기능)
// 1) 특정 사과장수에게 돈을 건넨다
//    (돈을 내 보유금액에서 차감)
//					2) 돈을 내 보유금액에 누적
// 					3) 사과 개수 계산 -> 나의 보유 사과갯수에서 차감 -> 사과 갯수 전달
// 4) 나의 보유 사과 개수에 누적




class Buyer{
	private int myMoney;
	private int appleCnt;
	
	public Buyer(int myMoney, int appleCnt) {
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
	public void payment(Seller seller, int money) {
		// 내 보유 금액에서 돈 차감
		myMoney-=money;
		// seller에게 money 전달 리턴되는 사과 개수 누적
		appleCnt+=seller.receive(money); 
	}
}
class Seller{
	private int myMoney;
	private int appleCnt;
	private int Price;
	
	public Seller(int myMoney, int appleCnt, int price) {
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.Price = price;
	}

	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", Price=" + Price + "]";
	}
	
	public int receive(int money) {
		// 전달받은 money 내 보유금액에 누적
		myMoney += money;
		// 전달받은 금액/사과 개수 return
		int apple = money/Price;
		// 보유 사과 갯수 차감
		appleCnt -= apple;
		return apple;
	}
}

public class ex_02 {
	public static void main(String[] args) {
		
		Seller seller = new Seller(10000,100,1000);
		
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 노홍철 = new Buyer(5000,0);
		
		홍길동.payment(seller, 5000);
		노홍철.payment(seller, 2000);
		
		System.out.println(홍길동);
		System.out.println(노홍철);
		System.out.println(seller);
		
		
	}
}

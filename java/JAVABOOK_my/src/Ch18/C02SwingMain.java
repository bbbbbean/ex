package Ch18;

import javax.swing.JFrame;


// 클래스가 관리가 편함 -> 클래스화 시키기
class C02GUI extends JFrame{
	// 프레임의 기본 옵션
	public C02GUI(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}



public class C02SwingMain {
	public static void main(String[] args) {
		new C02GUI("두번째 프레임입니다.");	
		
		
		
		
	}
}

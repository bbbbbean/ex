package Ch18;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


// 클래스가 관리가 편함 -> 클래스화 시키기
class C03GUI extends JFrame{
	
	public C03GUI(String title) {
		// Frame
		// 프레임의 기본 옵션
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// panel
		JPanel panel = new JPanel();
		// panel 배경색 변경
//		Color col = new Color(71,20,0);	// rgb 컬러코드
//		panel.setBackground(col);
		
		// Frame에 Panel 삽입
		add(panel);
	}
	
	
}



public class C03SwingMain {
	public static void main(String[] args) {
		new C03GUI("세번째 프레임입니다.");	
		
		
		
		
	}
}

package Ch18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


// 클래스가 관리가 편함 -> 클래스화 시키기
class C04GUI extends JFrame{
	
	public C04GUI(String title) {
		// Frame
		// 프레임의 기본 옵션
		super(title);
		setBounds(100,100,247,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// panel
		JPanel panel = new JPanel();
		// panel 배경색 변경
//		Color col = new Color(71,20,0);	// rgb 컬러코드
//		panel.setBackground(col);
		panel.setLayout(null);
		
		// Component
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10, 10, 100, 30);
		
		JButton btn2 = new JButton("BTN02");
		btn2.setBounds(120, 10, 100, 30);
		
		// 텍스트 input
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		
		JTextArea area1 = new JTextArea();
//		area1.setBounds(10,90,210,360);
		// JTextArea에 스크롤 추가
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,90,210,360);
		
		// panel에 component 추가
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
//		panel.add(area1);
		panel.add(scroll1);
		
		
		// Frame에 Panel 삽입
		add(panel);
		
		
		// Frame
		// 보이는 순서때문에 안보인거 보임 옵션 제일 마지막에 넣으면 중간 요소 잘보임
		setVisible(true);
	}
	
	
}



public class C04SwingMain {
	public static void main(String[] args) {
		new C04GUI("네번째 프레임입니다.");	
		
		
		
		
	}
}

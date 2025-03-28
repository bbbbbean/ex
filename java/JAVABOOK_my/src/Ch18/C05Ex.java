package Ch18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class GUI extends JFrame{	// 관련 함수를 쓰기 위해 상속
	
	//Component 참조변수명
	//textarea = area1
	//textarea's scroll = scroll1
	//파일로저장 : btn1
	//1:1요청 : btn2
	//대화기록보기 : btn3
	//입력 : input
	//textfield : txt1
	
	public GUI(String title) {
		super(title);
		
		setBounds(100,100,467,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기 시 프로세스 종료
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// 버튼 설정
		JButton btn1 = new JButton("파일로 저장"); 
		JButton btn2 = new JButton("1:1 요청"); 
		JButton btn3 = new JButton("대화기록보기"); 
		JButton input = new JButton("입력");
		
		btn1.setBounds(320,10,120,30);
		btn2.setBounds(320,50,120,30);
		btn3.setBounds(320,90,120,30);
		input.setBounds(320,520,120,40);
		
		// 텍스트 영역 설정
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,10,300,500);
		
		// 텍스트 입력 설정
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,520,300,40);
		
		
		// 패널에 연결
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		panel.add(scroll1);
		panel.add(txt1);
		
		// 프레임에 패널 연결
		add(panel);
		
		// 창 보이게 설정
		setVisible(true);
	}
	
	
	
	
	
}


public class C05Ex {

	public static void main(String[] args) {
		
		new GUI("Chatting Server");
		
	}

}

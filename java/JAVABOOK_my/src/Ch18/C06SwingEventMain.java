package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class C06GUI extends JFrame implements ActionListener{	// ActionListener 이벤트 추가를 위함
	
	// 이벤트 처리를 위해 각 버튼을 특정할 수 있도록 멤버 변수로 전환
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	
	public C06GUI(String title) {
		super(title);
		
		setBounds(100,100,467,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기 시 프로세스 종료
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// 버튼 설정
		btn1 = new JButton("파일로 저장"); 
		btn2 = new JButton("1:1 요청"); 
		btn3 = new JButton("대화기록보기"); 
		input = new JButton("입력");
		
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
		
		// event listener add
		// 각 버튼을 구별하려면? 해당 버튼임을 알리는 상태 전송 -> 이름 전송
		// 멤버 변수로 올려야 함수 바깥에서도 확인 가능
		btn1.addActionListener(this);	// btn1 상태 전송
		btn2.addActionListener(this);	// btn2 상태 전송
		btn3.addActionListener(this);	// btn3 상태 전송
		input.addActionListener(this);	// input 상태 전송
		
		
		
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

	// 이벤트 설정
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭");
		if(e.getSource()==btn1) {	
			System.out.println("파일로 저장");
		}else if(e.getSource()==btn2) {	
			System.out.println("1:1요청");
		}else if(e.getSource()==btn3) {	
			System.out.println("대화 기록 보기");
		}else{	
			System.out.println("입력");
		}
	}
	
	
	
	
	
}


public class C06SwingEventMain {

	public static void main(String[] args) {
		
		new C06GUI("Chatting Server");
		
	}

}

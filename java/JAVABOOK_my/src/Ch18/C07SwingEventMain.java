package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


class C07GUI extends JFrame implements ActionListener,KeyListener,MouseListener{	// ActionListener 이벤트 추가를 위함
	
	// 이벤트 처리를 위해 각 버튼을 특정할 수 있도록 멤버 변수로 전환
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	public C07GUI(String title) {
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
		input.addActionListener(this);	// input 상태 전송
		txt1.addKeyListener(this);
		area1.addMouseListener(this);
		
		
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
		System.out.println("keyPressed"+e.getKeyCode());	// 엔터 == 10
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


public class C07SwingEventMain {

	public static void main(String[] args) {
		
		new C07GUI("Chatting Server");
		
	}

}

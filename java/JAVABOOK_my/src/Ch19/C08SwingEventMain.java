package Ch19;

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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


class C08GUI extends JFrame implements ActionListener,KeyListener,MouseListener{	// ActionListener 이벤트 추가를 위함
	
	// 이벤트 처리를 위해 각 버튼을 특정할 수 있도록 멤버 변수로 전환
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	public C08GUI(String title) {
		super(title);
		
		setBounds(100,100,467,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기 시 프로세스 종료
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// 버튼 설정
		btn1 = new JButton("저장하기"); 
		btn2 = new JButton("불러오기"); 
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
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
			
			
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


public class C08SwingEventMain {

	public static void main(String[] args) {
		
		new C08GUI("Chatting Server");
		
	}

}

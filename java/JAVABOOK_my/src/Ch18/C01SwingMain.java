package Ch18;

import javax.swing.JFrame;

public class C01SwingMain {
	public static void main(String[] args) {
		
		// 프레임 직접 제작
		JFrame frame = new JFrame("프레임 제목란");
		// frame.setBounds(x,y,width,height); pixel단위
		frame.setBounds(100,100,500,500);
		// 프레임을 보이고 안보이게, javaw.exe - 그냥 닫는다고해서 안꺼짐 계속 구동중 -> 해당 옵션 넣어줘야함
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 꺼지는 옵션(작업관리자에서 꺼지나 확인해보기)
		frame.setVisible(true);
		
		
		
		
	}
}

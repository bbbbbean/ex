package Ch13ex;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		   
			//1조 : 원 -> 엔화
//			Won2Yen toYen = new Won2Yen(1446); // 1달러는 1446원
//			toYen.run();
			//2조 : 원 -> 유로
			Won2Euro toEuro = new Won2Euro(1562); // 1달러는 1446원
			toEuro.run();
			//3조 : 원 -> 위안
//			Won2Yuan  toYuan  = new Won2Yuan (1446); // 1달러는 1446원
//			toYuan .run();
			//4조 : 원 -> 페소
//			Won2Peso  toDollar = new Won2Peso (1446); // 1달러는 1446원
//			toPeso .run();
		
	}
}

package Ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 다음 보기 함수 sort, add, show를 완성해주세요
// 속성 : sc - 키보드 값 받기, wordList : 단어 저장
// sort : 오름차순/내림차순 정렬 - (3) 오름차순, 내림차순 확인
// add : 단어 추가 - (1) banana, orange, apple
// show : 저장된 단어 확인 - (2)

public class 문제1 {
	private static Scanner sc = new Scanner(System.in);
	private static List<String> wordList = new ArrayList<String>();
	
	public static void sort(boolean isAsend) {
		if(isAsend==true) {
			Collections.sort(wordList);
		}else {
			Collections.sort(wordList,Collections.reverseOrder());
		}
		for(String el:wordList) {
			System.out.println(el);
		}
	} 
	public static void add(String word) {
		wordList.add(word);
	}
	public static void show() {
		for(String el:wordList) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		
	int n = 0;
	while(true) {
		System.out.println("--------------M E N U--------------");
		System.out.println("1 추가");
		System.out.println("2 정렬");
		System.out.println("3 확인");
		System.out.println("4 종료");
		System.out.println("--------------M E N U--------------");
		System.out.println("번호 : ");
		n = sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("단어 입력 : ");
			String word = sc.next();
			add(word);
			break;
		case 2:
			System.out.println("오름차순 여부(1:오름차순, 0:내림차순) : ");
			int no = sc.nextInt();
			if(no==1) sort(true); else sort(false);
			break;
		case 3:
			show();
			break;
		case 4:
			System.out.println("종료합니다.");
			System.exit(-1);
			break;
		default:
			System.out.println("다시 입력하세요");
		
			}
		}
	}
}

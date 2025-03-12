package Ch17;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class C04Ex {
	public static void main(String[] args) {
		
		// 1 ) 1~45까지 숫자 6개를 랜덤으로 받아(Random 클래스 이용) set에 저장 / 출력

		Set<Integer> set = new HashSet<>();
		
		Random rand = new Random();
		for(int i=0;i<6;i++) {
			int r = rand.nextInt(45)+1;
			set.add(r);
		}
		System.out.println(set);
		
		// 2 ) 저장된 set 오름차순 정렬 - stream 함수 사용
		List<Integer> li = set.stream().sorted().collect(Collectors.toList());
		// Collectors.toList() : 정렬한 것을 list로 뺀다
		// list로 저장 필요
		for(Integer val:li) {
			System.out.print(val+" ");
		}
		
		
		// 3 )
		List<Integer> list = new ArrayList(set);
		Collection
		
		
		
	}
}

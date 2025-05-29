package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C04Sorted {
	public static void main(String[] args) {
		
		//Sorted
		List<Integer> numbers2 = Arrays.asList(5, 2, 8, 1, 4);
		List<Integer> sortedNumbers = numbers2.stream()
		                                     .sorted()
		                                     .collect(Collectors.toList());
		System.out.println(sortedNumbers); // 출력: [1, 2, 4, 5, 8]
	}
}

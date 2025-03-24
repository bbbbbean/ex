package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C06Skip {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> skippedNumbers = numbers.stream()
		                                      .skip(2)
		                                      .collect(Collectors.toList());
		System.out.println(skippedNumbers); // 출력: [3, 4, 5]
	}
}

package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C05Limited {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> limitedNumbers = numbers.stream()
		                                      .limit(3)
		                                      .collect(Collectors.toList());
		System.out.println(limitedNumbers); // 출력: [1, 2, 3]

	}

}

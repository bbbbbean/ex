package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C01MAP {

	public static void main(String[] args) {
		
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);
		System.out.println(numberList);
		
		
		List<Integer> evenList = numberList.stream()
											.filter((n)->n%2==0)
											.collect(Collectors.toList());
		
		
		System.out.println(evenList);
		
		
	}
	
}

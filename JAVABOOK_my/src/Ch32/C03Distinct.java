package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C03Distinct {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,2,3,3,3,4,5,5);
		System.out.println(list);
		
		List<Integer> distinctedList = 
		list.stream().distinct().collect(Collectors.toList());
		
		System.out.println(distinctedList);
		
	}
	
}

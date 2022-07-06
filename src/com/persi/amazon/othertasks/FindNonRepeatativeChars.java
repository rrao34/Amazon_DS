package com.persi.amazon.othertasks;

import java.util.List;
import java.util.stream.Collectors;

public class FindNonRepeatativeChars {

	public static void main(String[] args) {
		String name = "Rohit Rao";
		prinNonRepeatativeChars(name);

	}

	private static void prinNonRepeatativeChars(String name) {
		//Non Repeating characters
		/*Map<Character, Long> map = name.chars()
				.mapToObj(c-> (char)c).sorted().distinct().collect(Collectors.toList());
				.collect(Collectors
						.groupingBy(Function.identity(), Collectors.counting()));*/
		
		/*map.forEach((k, v) -> {
			if (v == 1) {
				System.out.println(k);
			}
		});
		*/
		
		//Distinct characters
		List<Character> map = name.chars()
				.mapToObj(c-> (char)c).sorted().distinct().collect(Collectors.toList());
		
		map.forEach( l-> {
			System.out.println(l);
		});
	}

}

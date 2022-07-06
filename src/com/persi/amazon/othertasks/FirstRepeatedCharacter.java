package com.persi.amazon.othertasks;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		String str = "Auto-generated method stub";
		
		findFirstRepeatingChar(str.toLowerCase());

	}

	private static void findFirstRepeatingChar(String str) {
		Map<Character, Long> map = str.chars()
				.mapToObj(c-> (char)c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<Character> optionalNonRepeatingChar = map.entrySet()
				.stream().filter(m -> m.getValue() == 1)
				.map(e-> e.getKey()).findFirst();
		
		if (optionalNonRepeatingChar.isPresent()) {
			 System.out.println("Non Repeating character - "+optionalNonRepeatingChar.get());
		}
		
		Optional<Entry<Character, Long>> optionalRepeatingChar = map.entrySet().stream()
		.max((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		
		if (optionalRepeatingChar.isPresent()) {
			System.out.println("First most repeating character - "+optionalRepeatingChar.get().getKey()+" - "+ optionalRepeatingChar.get().getValue());
		}
		
		
	}

}

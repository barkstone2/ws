package com.day15;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Test2 {
	public static void main(String[] args) {
		
		String[] lineArr = {
				"Belive or not It is true",
				"Do or do not There is no try"
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		Stream<String> strStream = lineStream.flatMap(line->Stream.of(line.split(" +")));
		strStream.forEach(System.out::println);
		
		
		Optional<String> optVal = Optional.of("abc");
		String str1 = optVal.orElse("");
		System.out.println(str1);
		
		
	}
}

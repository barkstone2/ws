package com.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) throws IOException {
		
		String[] strArr = {"aaa","bbb","ccc"};
		List<String> strList = Arrays.asList(strArr);
		
		
		
		Stream<String> strStream1 = strList.stream();
		Stream<String> strStream2 = Arrays.stream(strArr);
		
		strStream1.sorted().forEach(System.out::println);
		strStream2.sorted().forEach(System.out::println);
		
		
		Stream<Path> stp = Files.list(Paths.get("D:\\ws\\workspace\\"));
		stp.forEach(System.out::println);
		stp.close();
		
	}
}

package exam03;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Test01 {
	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<>();

		try {
			File fi = new File("D:\\ws\\attach\\test.txt");
			Scanner sc = new Scanner(fi);

			while (sc.hasNextLine()) {
//				@SuppressWarnings("resource")
//				Scanner sc2 = new Scanner(sc.nextLine()).useDelimiter(",");
//				list.add(new Student(sc2.next(),sc2.nextInt(),sc2.nextInt(),sc2.nextInt(),sc2.nextInt(),sc2.nextInt()));

				String data = sc.nextLine();
				String[] data_ = data.split(",");
				list.add(new Student(data_[0], Integer.parseInt(data_[1]), Integer.parseInt(data_[2]),
						Integer.parseInt(data_[3]), Integer.parseInt(data_[4]), Integer.parseInt(data_[5])));

			}
			sc.close();

		} catch (Exception e) {
		}

		System.out.println("이름\t국어\t영어\t수학\t과학\t역사\t총점\t평균");
		Stream<Student> stStream = list.stream();
		stStream.sorted((a, b) -> b.getTot() - a.getTot()).forEach(System.out::println);
		stStream = list.stream();
		Stream<String> nameStream = stStream.map(Student::getName);
		nameStream.map(s->s.substring(0,2))
				.peek(s->System.out.printf("name : %s%n",s))
				.forEach(System.out::println);
//		nameStream.forEach(System.out::println);
				
				
		
//		Student st = new Student();
//		Collections.sort(list, st::compare);
//		
//		Collections.sort(list, (a,b)-> b.getTot() - a.getTot());
//		
//		System.out.println("이름\t국어\t영어\t수학\t과학\t역사\t총점\t평균");
//		for(Student s : list)
//			System.out.println(s);

	}
}

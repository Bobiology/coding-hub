package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {
		//Integer stream with range 0 -10
		System.out.println("*******RANGE*******");
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		System.out.println();
		//Integer stream with skip
		System.out.println("*******SKIP*******");
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x ->System.out.print(x));
		System.out.println();
		//Integer Stream with sum
		System.out.println("*******SUM*******");
		System.out.println(IntStream.range(1, 5).sum());
		
		//Stream.of, sorted and findFirst
		System.out.println("*******STREAM OF*******");
		Stream.of("Ava","AAAA","Aneri","Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		System.out.println();
		//Stream from Array, sort, filter, and print
		System.out.println("*******ARRAY SORT FILTER & PRINT*******");
		String[] names = {"Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Sara"};
		Arrays.stream(names) //same as Stream.of(names)
			.filter(x ->x.startsWith("S"))
			.sorted()
			.forEach(x ->System.out.println(x));
		System.out.println();
		/**
		 * 2 = 4
		 * 4 = 16
		 * 6 = 36
		 * 8 = 64
		 * 10 = 100
		 * total 
		 * 5 = 220
		 */
		
		System.out.println("*******AVERAGE OF SQUARES OF INT ARRAY*******");
		Arrays.stream(new int[] {2,4,6,8,10})
			.map(x ->x*x)
			.average()
			.ifPresent(System.out::println);
		System.out.println();
		
		System.out.println("*******STREAM FROM LIST, FILTER, & PRINT*******");
		List<String> people = Arrays.asList(names);
		people
			.stream()
			.map(String::toLowerCase)
			.filter(x ->x.startsWith("a"))
			.forEach(System.out::println);
			
			

	}

}

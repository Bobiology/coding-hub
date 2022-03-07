package musala;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAttendance {
	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		data.add("YYYYY");
		data.add("YYYYY");
		data.add("YYYYY");
		data.add("YYYYY");
		data.add("YYYYY");
		data.add("YYNYY");
		data.add("YYYYY");
		data.add("YYYYY");
		data.add("YYYYY");
		System.out.println(maxStreak(3, data));
	}

	static int maxStreak(int m, List<String> data) {
		int count = 0;
		int maxConsecutive = 0;
		for (int i = 0; i < data.size(); i++) {
			if (findNOccurrences(data.get(i).toCharArray()) == 1) {
				count++;
			} else {
				count = 0;
			}
			maxConsecutive = Math.max(count, maxConsecutive);
		}

		return maxConsecutive;
	}

	static int findNOccurrences(char[] ch) {
		int count = 1;
		for (int i = 0; i < ch.length; i++) {
			System.out.println("CHARACTER = " + i + "==" + ch[i]);
			if (ch[i] == 'N') {
				count = 0;
			}
		}
		return count;
	}

}

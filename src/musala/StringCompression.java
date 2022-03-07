package musala;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compressedString("abaasass"));
		// aba2sas2
	}

	public static String compressedString(String message) {
		StringBuilder compressedString = new StringBuilder();
		int count = 1;
		char[] chars = message.toCharArray();
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1]) {
				count++;
			} else {
				compressedString.append(chars[i]);
				if (count > 1) {
					compressedString.append(String.valueOf(count));
				}
				count = 1;
			}
		}

		compressedString.append(chars[chars.length - 1]);
		if (count > 1) {
			compressedString.append(String.valueOf(count));
		}

		return compressedString + "";
	}

}

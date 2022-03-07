package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class SolutionIter implements Iterable<Integer> {
	
	public static void main(String[] args) {
		Reader inp;
	
		//SolutionIter(inp);
	}

	private List<Integer> input = new ArrayList<>();

	public SolutionIter(Reader inp) {

		BufferedReader bufferedReader = new BufferedReader(inp);

		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
// logic to convert
				if (line.matches("[0-9+-]+")) {
					input.add(Integer.parseInt(line));
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(SolutionIter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Iterator<Integer> iterator() {
		return new MyIterator();
	}
	private class MyIterator implements Iterator {

		private int index = 0;

		public boolean hasNext() {
			if (index < input.size())
				return true;
			else
				return false;
		}

		public Integer next() {
			if (this.hasNext()) {
				return input.get(index++);
			} else
				return null;
		}
	}

}
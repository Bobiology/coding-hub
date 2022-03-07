package codility;

public class StudentScores {

	public static void main(String[] args) {
		int[] score = {100, 90, 40, 30, 19, 60, 26, 48, 99, 45, 77, 64};
		int passmark =70;
		new StudentScores().getScoresAboveMark(score, passmark);
	}
	void getScoresAboveMark(int[] marks, int passmark ) {
		int count=0;
		for(int i=0;i<marks.length;i++) { // loop through the array
			if(marks[i]>=passmark) { //for every element confirm if >=70
				count ++; //increment
			System.out.println("Marks "+marks[i]+" index "+i);//output
			}
		}
		System.out.println("Total passed: "+count);
		
	}
}

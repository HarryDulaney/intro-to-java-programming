package ch_08;


/**
 * *8.3 (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to
 * display the students in increasing order of the number of correct answers.
 *
 */
public class Exercise08_03 {

	public static void main(String[] args) {
		// Students' answers to the questions
		char[][] answers = { { 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } };
		// Answer Key
		char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };

		// stuScore = integer [totalScore][Student number zero to 7]
		int[][] stuScores = new int[answers.length][2];

		for (int i = 0; i < answers.length; i++) {
			int ptsCount = 0;

			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j]) {
					ptsCount++;
				}

				stuScores[i][0] = ptsCount;
				stuScores[i][1] = i; //Track index of student
			}
		}

		// Selection Sort to sort student scores in ascending order
		for (int i = 0; i < stuScores.length - 1; i++) {
		
			for (int j = i + 1; j < stuScores.length; j++) {
				if (stuScores[j][0] < stuScores[i][0]) {
					int[] temp = stuScores[i];
					stuScores[i] = stuScores[j];
					stuScores[j] = temp;
				}
			}

		}

		for (int a = 0; a < stuScores.length; a++) {
			System.out.println("Student " + stuScores[a][1] + ": " + stuScores[a][0]);
		}

	}

}
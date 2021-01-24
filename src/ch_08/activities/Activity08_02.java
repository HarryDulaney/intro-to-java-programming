package ch_08.activities;

/* The key is stored in a one-dimensional array:
Students’ Answers to the Questions:
0 1 2 3 4 5 6 7 8 9
Student 0 A B A C C D E E A D
Student 1 D B A B C A E E A D
Student 2 E D D A C B E E A D
Student 3 C B A E D C E E A D
Student 4 A B D C C D E E A D
Student 5 B B E C C D E E A D
Student 6 B B A C C D E E A D
Student 7 E B E C C D E E A D
Key to the Questions:
0 1 2 3 4 5 6 7 8 9
Key D B D C C D A E A D */

/**
 * Your program grades the test and displays the result. It compares each
 * student’s answers with the key, counts the number of correct answers, and
 * displays it. Listing 8.2 gives the program.
 *
 */ //GradeExam
public class Activity08_02 {

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
		// Key to the questions
		char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };
		// Grade all answers
		for (int i = 0; i < answers.length; i++) {
			// Grade one student
			int correctCount = 0;
			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j])
					correctCount++;
			}
			System.out.println("Student " + i + "'s correct count is " + correctCount);
		}
	}
}

package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created: 03.10.2018
 * 
 * @author Georgi Georgiev
 */
public class Task3 {

	public static void main(String[] args) {
		String fileName = "sample.txt";
		int[][] matrix = fillMatrixFromFile(fileName);
		int maxSum = getMaxSum(matrix);
		System.out.println(maxSum);
	}

	/**
	 * @param fileName
	 *            - the name of file with matrix
	 * @return the matrix
	 */
	private static int[][] fillMatrixFromFile(String fileName) {
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int rows = 0;
		while (input.hasNextLine()) {
			++rows;
			input.nextLine();
		}
		int[][] a = new int[rows][rows];
		// read in the data
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < rows; ++j) {
				if (input.hasNextInt()) {
					a[i][j] = input.nextInt();
				}
			}
		}

		input.close();

		return a;
	}

	/**
	 * @param matrix
	 *            - the matrix in which max sum is searched
	 * @return the max sum in matrix
	 */
	private static int getMaxSum(int[][] matrix) {
		int maxSum = 0;

		for (int i = 0; i < matrix.length - 1; ++i) {
			for (int j = 0; j < matrix.length - 1; ++j) {
				int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}

		return maxSum;
	}
}

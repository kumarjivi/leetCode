package problems551to600;

/***
 * Given an m * n matrix M initialized with all 0's and several update
 * operations.
 * 
 * Operations are represented by a 2D array, and each operation is represented
 * by an array with two positive integers a and b, which means M[i][j] should be
 * added by one for all 0 <= i < a and 0 <= j < b.
 * 
 * You need to count and return the number of maximum integers in the matrix
 * after performing all the operations.
 * 
 * @author jivi
 *
 */
public class RangeAdditionII598 {

	public static void main(String[] args) {
		int[][] operations = { { 1, 1 }, { 1, 3 }, { 4, 4 } };
		System.out.println(maxCount(4, 4, operations));
	}

	public static int maxCount(int m, int n, int[][] ops) {
		int minX = m;
		int minY = n;
		for (int[] thisRow : ops) {
			minX = Math.min(thisRow[0], minX);
			minY = Math.min(thisRow[1], minY);
		}

		return minX * minY;
	}

}

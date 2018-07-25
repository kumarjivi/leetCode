package problems851to900;
/***
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 * @author jivi
 *
 */
public class TransposeMatrix868 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] output = new int[arr[0].length][arr.length];
		output = transpose(arr);
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] transpose(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int[][] output = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				output[j][i] = A[i][j];
			}
		}
		return output;
	}
}

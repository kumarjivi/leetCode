package problems301to350;
/***
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * @author jivi
 *
 */
public class LongestIncreasingPathInMatrix329 {

	public static void main(String[] args) {
		int[][] arr = {
				{3,4,5},
				{3,2,6},
				{2,2,1}};
		System.out.println(longestIncreasingPath(arr));
	}
	static int max = 0;
	static int[][] memo;
    public static int longestIncreasingPath(int[][] matrix) {
    	memo = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                helper(matrix, i, j, memo);
            }
        }
        return max;
    }
    
    public static int helper(int[][] arr, int i, int j, int[][] memo) {
    	if(i<0 || i>=arr.length || j<0 || j>=arr[0].length ) {
            return 0;
        }
        if(memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int val = arr[i][j];
        int top=1, bottom=1, left=1, right=1;
        int maxSoFar = 0;
        //check top
        if(i>0 && arr[i-1][j] < val) {
            top = 1 + helper(arr, i-1, j, memo);
        }
        //check left
        if(j>0 && arr[i][j-1] < val) {
            left = 1 + helper(arr, i, j-1, memo);
        }
        maxSoFar = Math.max(top, left);
        //check bottom
        if(i<arr.length-1 && arr[i+1][j] < val) {
            bottom = 1 + helper(arr, i+1, j, memo);
        }
        maxSoFar = Math.max(maxSoFar, bottom);
        //check right
        if(j<arr[0].length-1 && arr[i][j+1] < val) {
            right = 1 + helper(arr, i, j+1, memo);
        }
        maxSoFar = Math.max(left, Math.max(right, Math.max(top, bottom)));
        memo[i][j] = maxSoFar;
        max = Math.max(maxSoFar, max);
        return maxSoFar;
    }

}

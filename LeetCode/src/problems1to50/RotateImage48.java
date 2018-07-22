package problems1to50;
/***
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).
 * @author jivi
 *
 */
public class RotateImage48 {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				};
		rotate(arr);
		int len = arr.length;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) {
            return;
        }
        int layer = 0;
        int len = matrix.length;
        int maxLayer = (len-1)/2;
        while(layer <= maxLayer) {
            for(int i=layer; i<len-layer-1; i++) {
                //top to right.
                int right = matrix[i][len-layer-1];//store right.
                matrix[i][len-layer-1] = matrix[layer][i];
                
                //right to bottom
                int bottom = matrix[len-layer-1][len-i-1];
                matrix[len-layer-1][len-i-1] = right;
                
                //bottom to left
                int left = matrix[len-i-1][layer];
                matrix[len-i-1][layer] = bottom;
                
                //left to top
                matrix[layer][i] = left;
            }
            layer++;
        }
    }

}

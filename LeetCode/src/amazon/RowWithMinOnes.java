package amazon;

import java.util.Scanner;

public class RowWithMinOnes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases:");
		int numCases = sc.nextInt();
		for(int k=0; k<numCases; k++) {
			System.out.println("For test case "+k);
			System.out.println("Enter the number of rows in matrix:");
			int rows = sc.nextInt();
			System.out.println("Enter the number of columns in matrix:");
		    int cols = sc.nextInt();
		    if(rows == 0 || cols == 0) {
		        System.out.println("-1");;
		    }
		    int[][] arr = new int[rows][cols];
		    
		    for(int i=0; i<rows; i++) {
		        for(int j=0; j<cols; j++) {
		            arr[i][j] = sc.nextInt();
		        }
		    }
		    int output = getThatIndex(arr);
		    System.out.println("Row with min number of 1's is: "+output);
		}
	}
	
	private static int getThatIndex(int[][] arr) {
	    int rows = arr.length;
	    int cols = arr[0].length;
	    int minIndex = -1;
	    for(int j=cols-1; j>=0; j--) {
	        int sum = 0;
	        int i=0;
	        for(; i<rows; i++) {
	            sum+=arr[i][j];
	        }
	        if(sum != rows && sum > 0) {
	            return checkThisCol(arr, j);
	        } else if(sum > 0){
	            if(minIndex == -1) {
	                minIndex = 0;
	            }
	        }
	    }
	    return minIndex;
	}
	
	private static int checkThisCol(int[][] nums, int colNum) {
	    for(int i=0; i<nums.length; i++) {
	        if(nums[i][colNum] == 0) {
	            return i;
	        }
	    }
	    return -1;
	}

}

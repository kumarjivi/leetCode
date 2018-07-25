package problems1to50;

/***
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * @author jivi
 *
 */
public class TrappingRainWater42 {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr));
	}

	public static int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		// if(height.length == 1)
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		left[0] = height[0];
		right[right.length - 1] = height[height.length - 1];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}
		int waterSoFar = 0;
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(left[i], right[i]);
			waterSoFar += temp - height[i];
		}
		return waterSoFar;
	}
}

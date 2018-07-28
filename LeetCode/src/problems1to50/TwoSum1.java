package problems1to50;

import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * @author jivi
 *
 */
public class TwoSum1 {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 8, 7, 5, 6, 54, 5, 1, 5, 15, 42 };
		int[] ans = twoSum(arr, 24);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] output = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				int index = map.get(target - nums[i]);
				output[0] = Math.min(i, index);
				output[1] = Math.max(i, index);
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return output;
	}

}

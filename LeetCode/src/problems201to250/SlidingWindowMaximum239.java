package problems201to250;

import java.util.ArrayList;
import java.util.List;
/***
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * 
 * @author jivi
 *
 */
public class SlidingWindowMaximum239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,-1,-3,5,3,6,7};
//		int[] arr = {};
		int k = 2;
		int[] output = maxSlidingWindow(arr, k);
		for(int i : output) {
			System.out.print(i+" ");
		}
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] output = new int[nums.length - k+1];
        int index = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        //insert first k indexes in non-increasing order.
        int i = 0;
        for(; i<k; i++) {
            //remove all indexes which contain value less than arr[i]
            while(!list.isEmpty() && nums[list.get(list.size()-1)] < nums[i]) {
                list.remove(list.size()-1);
            }
            list.add(i);
        }
        
        for(; i<n; i++) {
            
            output[index++] = nums[list.get(0)];
            //remove out of window elements.
            while(!list.isEmpty() && list.get(0)+k <= i) {
                list.remove(0);
            }
            
            while(!list.isEmpty() && nums[list.get(list.size()-1)] < nums[i]) {
                list.remove(list.size()-1);
            }
            list.add(i);
        }
        output[index] = nums[list.get(0)];
        return output;
    }
}

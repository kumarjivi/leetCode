package problems400to450;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401 {
	
	public List<String> readBinaryWatch(int num) {
		List<String> answer = new ArrayList<>();
		int[] hours = new int[] {1,2,4,8};
		int[] minutes = new int[] {1,2,4,8,16,32};
		List<Integer> hh = new ArrayList<>();
		List<Integer> mm = new ArrayList<>();
		for(int i=0; i<=num; i++) {
			hh = getNumbers(hours, i, 0, 0, new ArrayList<Integer>());
			mm = getNumbers(minutes, num-i, 0, 0, new ArrayList<Integer>());
			for(int hour : hh) {
				if(hour < 12) {
					for(int min : mm) {
						if(min < 60) {
							String minString = String.valueOf(min);
							if(min < 10) {
								minString = "0"+minString;
							}
							answer.add(hour+":"+minString);
						}
					}
				}
			}
		}
		return answer;
    }
	
	private List<Integer> getNumbers(int[] nums, int count, int pos, int sum, List<Integer> result) {
		getNumbersHelper(nums, count, pos, sum, result);
		return result;
	}
	
	private void getNumbersHelper(int[] nums, int count, int pos, int sum, List<Integer> result) {
		if(count == 0) {
			result.add(sum);
			return;
		} else {
			for(int i=pos; i<nums.length; i++) {
				getNumbersHelper(nums, count-1,i+1, sum+nums[i], result);
			}
		}
	}
} 

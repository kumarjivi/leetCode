package problems1to50;

public class FirstMissingPositive41 {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
        int temp=0;
        int ind2=0;
        for(int i=0; i<len; i++) {
            while((nums[i] <len && nums[i] >0) && (nums[i] != nums[nums[i]-1])) {
                temp = nums[i];
                ind2 = nums[i]-1;
                nums[i] = nums[ind2];
                nums[ind2] = temp;
            }
        }
        for(int i=0; i<len; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }
}

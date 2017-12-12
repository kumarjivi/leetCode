package problems301to350;
/***
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num.
 * Calculate the number of 1's in their binary representation and return them as an array.
 * @author kjivi
 *
 */
public class CountingBits338 {
	public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num < 0) {
            return null;
        }
        int index = 1;
        ans[0] = 0;
        int pow = 1, t = 1;
        while(index <= num) {
            if(pow == index) {
                pow = pow*2;
                t = 0;
            }
            ans[index] = ans[t] + 1;
            index++;
            t++;
        }
        return ans;
    }
}

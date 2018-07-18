package problems851to900;
/***
 * Given a positive integer N, find and return the longest distance
 * between two consecutive 1's in the binary representation of N.
 * f there aren't two consecutive 1's, return 0.
 * @author jivi
 *
 */
public class BinaryGap868 {

	public static void main(String[] args) {
		System.out.println(binaryGap(8));
	}
	
	public static int binaryGap(int N) {
		if(N<=3 ){//|| N == Math.pow(2, (int)(Math.log(N)/Math.log(2)))) {
			return 0;
		}
        //System.out.println(Integer.toBinaryString(N));
        String str = Integer.toBinaryString(N);
        char[] arr = str.toCharArray();
        int start = 0;
        int maxGap = 0;
        int i=1;
        int len = arr.length;
        while(i<len) {
        	if(arr[i] == '1') {
        		maxGap = Math.max(maxGap, i-start);
        		start = i;
        	}
        	i++;
        }
        return maxGap;
    }

}

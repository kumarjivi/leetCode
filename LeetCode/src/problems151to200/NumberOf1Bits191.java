package problems151to200;

public class NumberOf1Bits191 {
	public int hammingWeight(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}

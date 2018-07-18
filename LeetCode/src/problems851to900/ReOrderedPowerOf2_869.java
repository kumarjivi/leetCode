package problems851to900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReOrderedPowerOf2_869 {

	public static void main(String[] args) {
		int num = 46;
		System.out.println(reorderedPowerOf2(num));
	}
	public static boolean reorderedPowerOf2(int N) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        long curr = 1;
        while(curr <= Integer.MAX_VALUE) {
            int len = String.valueOf(curr).length();
            List<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(len)) {
                list = map.get(len);
            }
            list.add((int)curr);
            map.put(len, list);
            curr *= 2;
        }
        List<Integer> list = map.get(String.valueOf(N).length());
        for(int element : list) {
            if(isAnagram(element, N)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isAnagram(int one, int two) {
        char[] s1 = String.valueOf(one).toCharArray();
        char[] s2 = String.valueOf(two).toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(new String(s1).equals(new String(s2))) {
            return true;
        } else {
            return false;
        }
    }
}

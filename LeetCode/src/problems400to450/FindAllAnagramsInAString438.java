package problems400to450;

import java.util.ArrayList;
import java.util.List;
/***
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lower-case English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * @author jivi
 *
 */
public class FindAllAnagramsInAString438 {

	public static void main(String[] args) {
		String one = "ababababababbbababababaaababbaab";
		String two = "ab";
		List<Integer> output = findAnagrams(one, two);
		output.forEach(x -> System.out.print(x+" "));
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<Integer>();
        if(s == null) {
            return output;
        }
        int len = s.length();
        int pLen = p.length();
        if(len < pLen) {
            return output;
        }
        if(p==null || pLen == 0) {
            for(int i=0; i<=len; i++) {
                output.add(i);
            }
            return output;
        }
        
        int[] pFreq = new int[26];
        char[] arr = p.toCharArray();
        for(char ch : arr) {
            pFreq[ch-'a'] = pFreq[ch-'a'] + 1;
        }
        int[] sFreq = new int[26];
        
        int i=0;
        for(i=0; i<pLen-1; i++) {
            char ch = s.charAt(i);
            sFreq[ch-'a'] = sFreq[ch-'a'] + 1;
        }
        int j=0;
        while(i<len) {
            char ch = s.charAt(i);
            sFreq[ch-'a']++;
            if(isSame(sFreq, pFreq)) {
                output.add(j);
            }
            sFreq[s.charAt(j)-'a']--;
            j++;
            i++;
        }
        return output;
    }
    private static boolean isSame(int[] one, int[] two) {
        if(one.length != two.length) {
            return false;
        }
        for(int i=0; i<one.length; i++) {
            if(one[i] != two[i]) {
                return false;
            }
        }
        return true;
    }

}

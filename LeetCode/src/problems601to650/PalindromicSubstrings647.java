package problems601to650;
/***
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * Example:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Input: "aaa"
 * Output: 6 
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * @author kjivi
 *
 */
public class PalindromicSubstrings647 {
	public int countSubstringsBruteForce(String s) {
		int count = 0;
		int len = s.length();
		//for(int i=0; i<len; i++) {
//			System.out.println("loop1:"+s.charAt(i));
			for(int j=0; j<len; j++) {
//				System.out.println("loop2:"+s.charAt(j));
				for(int k=j+1; k<=len; k++) {
					if(k<len) {
//						System.out.println("loop3:"+s.charAt(k));
					}
					String temp = s.substring(j, k);
					if(isPalindrome(temp)) {
						count++;
					}
//					System.out.println(temp);
				}
			}
		//}
        return count;
    }
	
	private boolean isPalindrome(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		int len = str.length();
		int start = 0;
		int end = len-1;
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}

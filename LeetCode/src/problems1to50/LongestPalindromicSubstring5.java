package problems1to50;

/***
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * @author jivi
 *
 */
public class LongestPalindromicSubstring5 {

	public static void main(String[] args) {
		String s = "aadsdsgsdadsfsdsdafadsasad";
		System.out.println(longestPalindrome(s));
	}

	static int max = 0;
	static String output = "";

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int thisMax = biggestPalindromeWithCenter(arr, i, i);
			process(s, thisMax, i, i);
			if (i + 1 < arr.length) {
				thisMax = biggestPalindromeWithCenter(arr, i, i + 1);
				process(s, thisMax, i, i + 1);
			}
		}
		return output;
	}

	private static void process(String s, int thisMax, int left, int right) {
		if (thisMax > max) {
			max = thisMax;
			int l = left - (max - 1) / 2;
			int r = right + (max - 1) / 2;
			output = s.substring(l, r + 1);
		}
	}

	private static int biggestPalindromeWithCenter(char[] arr, int left, int right) {
		while (left >= 0 && right < arr.length) {
			if (arr[left] != arr[right]) {
				return right - left - 1;
			}
			left--;
			right++;
		}
		if (left < 0 || right == arr.length) {
			left++;
			right--;
		}
		return right - left + 1;

	}

}

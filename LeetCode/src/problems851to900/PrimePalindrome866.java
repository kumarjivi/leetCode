package problems851to900;
/***
 * Find the smallest prime palindrome greater than or equal to N.
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1. 
 * For example, 2,3,5,7,11 and 13 are primes.
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left. 
 * For example, 12321 is a palindrome.
 * @author jivi
 *
 */
public class PrimePalindrome867 {

	public static void main(String[] args) {
		int num = 9547458;
		System.out.println(primePalindrome(num));
	}
	
	public static int primePalindrome(int N) {
		if (N <= 2) {
			return 2;
		} else if (N == 3) {
			return N;
		}
		while (true) {
			if (N == isPalindrome(N) && isPrime(N)) {
				return N;
			}
			N++;
			if (10_000_000 < N && N < 100_000_000)
				N = 100_000_000;
		}
	}

	public static int isPalindrome(int num) {
		int rev = 0;
		while (num > 0) {
			rev = rev * 10 + (num % 10);
			num /= 10;
		}
		return rev;
	}
	
	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		int sq = (int) Math.sqrt(num);
		for (int i = 2; i <= sq; ++i) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}

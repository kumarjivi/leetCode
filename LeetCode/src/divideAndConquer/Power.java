package divideAndConquer;
/***
 * Write a program to calculate pow(x,n)
 * Given two integers x and n, write a function to compute xn.
 * We may assume that x and n are small and overflow doesn’t happen.
 * @author kjivi
 *
 */
public class Power {

	public static void main(String[] args) {
		System.out.println(pow(34.00515,-3));
	}
	
	public static double pow(double x, int n) {
		if(n == 0) {
			return 1;
		}
		double temp = pow(x,n/2);
		if(n%2 == 0) {
			return temp * temp;
		} else {
			if(n > 0) {
				return x * temp * temp;
			} else {
				return (temp * temp) / x;
			}
		}
	}
}
package problems1to50;

public class Pow50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(0.02, -2));

	}

	public static double myPow(double x, int n) {
		double temp;
		if(n==0) {
			return 1;
		}
		temp = myPow(x, n/2);
		if(n%2 == 0) {
			return temp*temp;
		} else {
			if(n>0) {
				return x*temp*temp;
			} else {
				return temp*temp/x;
			}
		}
	}
}

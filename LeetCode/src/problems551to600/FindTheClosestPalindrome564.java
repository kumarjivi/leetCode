package problems551to600;
/***
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * The 'closest' is defined as absolute difference minimized between two integers.
 * @author jivi
 *
 */
public class FindTheClosestPalindrome564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "10001";
		System.out.println(nearestPalindromic(str));
	}
	
	public static boolean allNines(String str) {
        char[] arr = str.toCharArray();
        for(char ch : arr) {
            if(ch != '9') {
                return false;
            }
        }
        return true;
    }
	public static boolean isSpecialCase(String s) {
		long val = Long.parseLong(s);
		int numDigit = (int)(Math.log10(val) + 1);
		long num = (long)(Math.pow(10, numDigit-1));
		if(Math.abs(val - num) <= 1) {
			return true;
		}
		return false;
	}
	public static String nearestPalindromic(String n) {
		if(n == null || n.length() == 0) {
			return n;
		}
		long val = Long.parseLong(n);
        n = String.valueOf(val);
		int len = n.length();
		
		if(len == 1) {
            return String.valueOf(val-1);
        }
        
        //special case: of the form 10, 100, 1000
        if(isSpecialCase(n)) {
        	int numDigit = (int)(Math.log10(val) + 1);
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<numDigit-1; i++) {
        		sb.append("9");
        	}
            return sb.toString();
        }
        
		//case 1. all digits are 9.
		if(allNines(n)) {
			val += 2;
			return String.valueOf(val);
		}
		String half = n.substring(0, len/2);
		//case 2. replace 2nd half with rev(1st half)
		long diffTwo = Long.MAX_VALUE, diffThree = Long.MAX_VALUE, diffFour = Long.MAX_VALUE;
		String caseTwo = "", caseThree="", caseFour = "";
		if(len % 2 == 0) {
			caseTwo = half+(new StringBuilder(half).reverse().toString()); 
			diffTwo = Long.parseLong(n) - Long.parseLong(caseTwo);
		} else {
			//half = n.substring(0, len/2);
			caseTwo = half+n.charAt(len/2)+(new StringBuilder(half).reverse().toString());
			diffTwo = Long.parseLong(n) - Long.parseLong(caseTwo);
		}
		diffTwo = diffTwo == 0 ? Long.MAX_VALUE : diffTwo;
		//case 3. add 1 to first half, then replace 2nd half with rev(1st half)
		//half = n.substring(0, len/2);
		caseThree = updateDecValue(n, true);
		diffThree = Long.parseLong(n) - Long.parseLong(caseThree);
		diffThree = diffThree == 0 ? Long.MAX_VALUE : diffThree;
		//case 4. sub 1 from first half, then replace 2nd half with rev(1st half)
		caseFour = updateDecValue(n, false);
		diffFour = Long.parseLong(n) - Long.parseLong(caseFour);
        diffFour = diffFour == 0 ? Long.MAX_VALUE : diffFour;
        
		String output = "";
		long minDiff = 0l;
		diffTwo = Math.abs(diffTwo);
		diffThree = Math.abs(diffThree);
		diffFour = Math.abs(diffFour);
		System.out.println("diffTwo: "+diffTwo);
        System.out.println("caseTwo: "+caseTwo);
		System.out.println("diffThree: "+diffThree);
        System.out.println("caseThree: "+caseThree);
		System.out.println("diffFour: "+diffFour);
        System.out.println("caseFour: "+caseFour);
		if(diffThree < diffTwo) {
			minDiff = diffThree;
			output = caseThree;
		} else if(diffThree == diffTwo){
			minDiff = diffTwo;
			output = Long.parseLong(caseTwo) > Long.parseLong(caseThree) ? caseThree : caseTwo;
		} else {
            minDiff = diffTwo;
            output = caseTwo;
        }
		if(diffFour < minDiff) {
			//minDiff = diffFour;
			output = caseFour;
		} else if (diffFour == minDiff) {
            output = Long.parseLong(output) > Long.parseLong(caseFour) ? caseFour : output;
        }
		return output;
		
	}
	
	private static String updateDecValue(String str, boolean incMode) {
		int len  = str.length();
		String half = str.substring(0, (len+1)/2);
		int halfInt = Integer.parseInt(half);
		if(incMode) {
			halfInt++;
		} else {
			halfInt--;
		}
		half = String.valueOf(halfInt);
		return half + new StringBuilder(half.substring(0, len/2)).reverse().toString();
	}

}

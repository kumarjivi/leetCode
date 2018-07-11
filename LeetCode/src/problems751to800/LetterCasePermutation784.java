package problems751to800;

import java.util.ArrayList;
import java.util.List;
/***
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * Example:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * @author jivi
 *
 */
public class LetterCasePermutation784 {

	public static void main(String[] args) {
		String s = "s717";
		List<String> output = letterCasePermutation(s);
		output.forEach(x -> System.out.print(x+" "));
	}
	
	public static List<String> letterCasePermutation(String S) {
        List<String> output = new ArrayList<String>();
        helper(output, 0, S.toCharArray(), "");
        return output;
    }
    
    private static void helper(List<String> output, int i, char[] arr, String soFar) {
        if(i == arr.length) {
            output.add(soFar);
            return;
        }
        char ch = arr[i];
        if(ch >= '0' && ch <= '9') {
            helper(output, i+1, arr, soFar+ch);
        } else {
            //lower case
            if(ch >= 'a' && ch <= 'z') {
                helper(output, i+1, arr, soFar+ch);
            } else {
                ch += 32;
                helper(output, i+1, arr, soFar+ch);
            }
            
            //upper case
            if(ch >= 'A' && ch <= 'Z') {
                helper(output, i+1, arr, soFar+ch);
            } else {
                ch -= 32;
                helper(output, i+1, arr, soFar+ch);
            }
        }
    }

}

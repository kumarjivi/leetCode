package problems1to50;

import java.util.ArrayList;
import java.util.List;

/***
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @author jivi
 *	
 */
public class GenerateParentheses22 {

	public static void main(String[] args) {
		List<String> output = generateParenthesis(4);
		output.forEach(s->System.out.println(s));
	}
	public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        int open = 0, close = 0;
        helper(output, "", open, close, n);
        return output;
    }
    
    private static void helper(List<String> output, String soFar, int open, int close, int n) {
        if(open == n && close == n) {
            output.add(soFar);
            return;
        }
        if(open < n) {
            helper(output, soFar+"(", open+1, close, n);
        }
        if(close < open) {
            helper(output, soFar+")", open, close+1, n);
        }
    }
}

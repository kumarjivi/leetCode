package backtracking;

import java.util.ArrayList;
import java.util.List;
/***
 * Given an integer n, print all the binary strings possible of length n.
 * @author kumar
 *
 */
public class PrintBinaryString {
	static List<StringBuilder> list = new ArrayList<StringBuilder>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getBinaryStrings(3);
		printList(list);

	}
	
	public static List<StringBuilder> getBinaryStrings(int n) {
		helper(new StringBuilder(""), 4);
		printList(list);
		return list;
	}
	
	public static void helper(StringBuilder str, int target) {
		if(str.length() == target) {
			list.add(new StringBuilder(str));
			return;
		} else {
			helper(str.append("0"), target);
			str.setCharAt(str.length()-1, '1');
			helper(str, target);
			str.deleteCharAt(str.length()-1);
			//helper(str.deleteCharAt(str.length()-1),target);
		}
	}
	
	public static void printList(List<StringBuilder> list) {
		for(StringBuilder i : list) {
			System.out.print(i+",");
		}
		System.out.println();
	}

}

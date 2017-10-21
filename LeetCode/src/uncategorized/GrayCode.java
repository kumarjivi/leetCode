package uncategorized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrayCode {
	static List<String> str = new ArrayList<String>();
	public static void main(String[] args) {
		grayCode(0);
	}
	
	public static List<Integer> grayCode(int n) {
		str.add("0");
		str.add("1");
		str.add("11");
		str.add("10");
		Collections.sort(str, myComp);
		for(String s: str) {
			System.out.println(s);
		}
		return null;
	 }
	 
	 private static void helper(StringBuilder str, int target) {
		 if(str.length() == target) {
			 return;
		 } else {
			 str.append("0");
		 }
	 }
	
	static Comparator<String> myComp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	};
}

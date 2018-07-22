package problems751to800;

import java.util.ArrayList;
import java.util.List;

/***
 * A string S of lowercase letters is given. We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * @author jivi
 *
 */
public class PartitionLabels763 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abadehijhklij";
		List<Integer> output =partitionLabels(str);
		output.forEach(x -> System.out.print(x+" "));
	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> output = new ArrayList<Integer>();
		int[] arr = new int[26];
		char[] chArr = S.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			char ch = chArr[i];
			arr[ch - 'a'] = Math.max(arr[ch - 'a'], i);
		}
		int maxRangeSoFar = arr[chArr[0] - 'a'];
		int count = 0;
		for (int i = 0; i < chArr.length; i++, count++) {
			maxRangeSoFar = Math.max(maxRangeSoFar, arr[chArr[i] - 'a']);
			if (i == maxRangeSoFar) {
				output.add(count + 1);
				count = -1;
			}

		}
		return output;
	}

}

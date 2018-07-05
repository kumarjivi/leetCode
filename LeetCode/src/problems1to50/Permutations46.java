package problems1to50;

import java.util.ArrayList;
import java.util.List;
/***
 * Given a collection of distinct integers, return all possible permutations.
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author jivi
 *
 */
public class Permutations46 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		List<List<Integer>> output = permute(arr);
		output.forEach(list -> {list.forEach(num -> System.out.print(num+" ")); System.out.println();});
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> candidates = new ArrayList<Integer>();
		List<Integer> processed = new ArrayList<Integer>();
		for (int i : nums) {
			candidates.add(i);
		}
		helper(output, processed, candidates);
		return output;

	}

	private static void helper(List<List<Integer>> output, List<Integer> processed, List<Integer> candidates) {
		if (candidates.size() == 0) {
			output.add(new ArrayList<Integer>(processed));
		} else {

			for (int i = 0; i < candidates.size(); i++) {
				// choose
				int num = candidates.remove(i);
				processed.add(num);

				// explore
				helper(output, processed, candidates);

				// un-choose
				candidates.add(i, num);
				processed.remove(processed.size() - 1);
			}

		}
	}

}

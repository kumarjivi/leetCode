package problems551to600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 * 
 * @author jivi
 *
 */
public class MinimumIndexSumOfTwoLists599 {

	public static void main(String[] args) {
		String one[] = {"Shogun", "Burger King", "KFC", "Tapioca Express"};
		String two[] = {"KFC", "Burger King", "Shogun"};
		String[] out = findRestaurant(one, two);
		for(String str : out) {
			System.out.println(str);
		}
	}
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> restVsPosMap = new HashMap<String, Integer>();
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (int i = 0; i < list1.length; i++) {
			restVsPosMap.put(list1[i], i);
		}
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			if (restVsPosMap.containsKey(list2[i])) {
				int sum = i + restVsPosMap.get(list2[i]);
				List<String> list = new ArrayList<String>();
				if (map.containsKey(sum)) {
					list = map.get(sum);

				}
				list.add(list2[i]);
				map.put(sum, list);
				minSum = Math.min(minSum, sum);
			}
		}
		List<String> list = map.get(minSum);
		String[] out = new String[list.size()];
		int i = 0;
		for (String str : list) {
			out[i++] = str;
		}
		return out;
	}
}

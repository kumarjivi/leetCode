package problems1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @author jivi
 *
 */
public class GroupAnagrams49 {
	static List<Map<Character, Integer>> mapList;
	static Map<Character, Integer> tempMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> output = groupAnagrams(strs);
		for(List<String> list : output) {
			list.forEach(s -> System.out.print(s+" "));
			System.out.println();
		}
	}
	
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(strs.length == 0) {
        	return output;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
        	char[] arr = s.toCharArray();
        	Arrays.sort(arr);
        	String sorted = String.valueOf(arr);
        	List<String> list = new ArrayList<String>();
        	if(map.containsKey(sorted)) {
        		list = map.get(sorted);
        	}
        	list.add(s);
        	map.put(sorted, list);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
        	output.add(entry.getValue());
        }
        return output;
    }
}














package subSeq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
//		String s = "abcdedcbah";
		System.out.println(lengthOfLongestSubstring1(s));
//		Set<Character> set = new HashSet<Character>();
//		set.add('a');
//		set.add('b');
//		set.add('c');
//		set.remove('a');
//		printSet(set);
	}
	
	public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	
	public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        List<Character> list = new ArrayList<Character>();
        int maxSize = 0;
        char thisChar = ' ';
        for(int i=0; i<s.length(); i++) {
            thisChar = s.charAt(i);
			if (!set.add(thisChar)) {
				while (list.get(0) != thisChar) {
					set.remove(list.get(0));
					list.remove(0);
				}
				if (list.size() > 0)
					list.remove(0);
			}
            list.add(thisChar);
            if(set.size() > maxSize)
                maxSize = set.size();
            //maxSize = hashSet.size() > maxSize ? hashSet.size() : maxSize
            System.out.println("thisChar: "+thisChar);
            System.out.print("set:");
            printSet(set);
            System.out.print("list:");
            printList(list);
        }
        return maxSize;
    }
	
	private static void printList(List<Character> list) {
		for(Character i : list) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	private static void printSet(Set<Character> set) {
		for(Character i : set) {
			System.out.print(i+",");
		}
		System.out.println();
	}

}

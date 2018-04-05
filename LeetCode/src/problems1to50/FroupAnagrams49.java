package problems1to50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FroupAnagrams49 {
	static List<Map<Character, Integer>> mapList;
	static Map<Character, Integer> tempMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> output = groupAnagrams(strs);
	}
	
	private static void addNewMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        mapList.add(map);
    }
    
    private static int getMapId(String s) {
        Map<Character, Integer> thisMap;
        if(mapList.size() == 0) {
            return -1;
        } else {
            for(int i=0; i<mapList.size(); i++) {
            	tempMap = new HashMap<Character, Integer>(mapList.get(i));
                //thisMap = mapList.get(i);
                if(isMapMatchesString(s, tempMap)) {
                    return i;
                }
            }
            return -1;
        }
    }
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        mapList = new ArrayList<Map<Character, Integer>>();
        List<List<String>> output = new ArrayList<List<String>>();
        List<String> tempList;
        for(String thisString : strs) {
            System.out.println("thisString: "+thisString);
            int mapId = getMapId(thisString);//get the id to which map for this string is stored.
            System.out.println("mapId: "+mapId);
            if(mapId == -1) {// not stored ever
                mapId = mapList.size();
                //addNewMap(s, mapId);//store map for this string at this id in mapList.
                addNewMap(thisString);
                tempList = new ArrayList<String>();
                tempList.add(thisString);
                output.add(tempList);
            } else {
                tempList = output.get(mapId);
                tempList.add(thisString);
            }
        }
        return output;
    }
	
	private static boolean isMapMatchesString(String s, Map<Character, Integer> map) {
        for(int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if(!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            } else {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }

}
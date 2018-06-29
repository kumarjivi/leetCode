package problems101to150;

import java.util.ArrayList;
import java.util.List;
/***
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 * @author jivi
 *
 */
public class WordLadder127 {
	List<String> queue = new ArrayList<String>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty() || beginWord.length() != endWord.length()) {
            return 0;
        }
        if(beginWord.equals(endWord) || wordList.indexOf(endWord)==-1 ) {//hit  cog
            return 0;
        }//["hot","dot","dog","lot","log","cog"]
        queue.add(beginWord);
        //boolean found = true;
        int level = 1;
        while(!queue.isEmpty()) {//
            int len = queue.size();
            //System.out.println("size: "+len);
            for(int i=0; i<len; i++) {
               String thisWord = queue.remove(0);//hit
                if(endWord.equals(thisWord)) {
                    return level;
                }  
                List<String> unitDistaneAway = getOneDistanceWords(wordList, thisWord);
                //System.out.println(unitDistaneAway.size());
                if(!unitDistaneAway.isEmpty()) {
                    for(String s : unitDistaneAway) {
                        queue.add(s);
                    }
                }
            }
            level++;
            //System.out.println("level: "+level);
        }
        return 0;
    }
    
    List<String> getOneDistanceWords(List<String> list, String word) {
        List<String> output = new ArrayList<String>();
        for(int i=0; i<list.size(); i++) {
            String thisWord = list.get(i);
            if(isOneDistance(thisWord, word)) {
                output.add(list.remove(i));
                i--;
            }
        }
        return output;
    }
    
    private boolean isOneDistance(String one, String two) {
        int diffCount = 0;
        if(one.length() != two.length()) return false;
        char[] arrOne = one.toCharArray();
        char[] arrTwo = two.toCharArray();
        int len = arrOne.length;
        for(int i=0; i<len; i++) {
            if(arrOne[i] != arrTwo[i]) {
                diffCount++;
                if(diffCount > 1) {
                    return false;
                }      
            }
        }
        if(diffCount == 1) {
            return true;
        }
        return false;
    }	
}

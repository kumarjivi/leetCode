package problems651to700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * 
 * @author jivi
 *
 */
public class TopKFrequentWords692 {

	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 3;
		List<String> list = topKFrequent(words, k);
		list.forEach(s -> System.out.print(s+" "));

	}
	
	public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> output = new ArrayList<String>();
        List<Integer> freqList = new ArrayList<Integer>();
        Map<Integer, List<String>> freqVsList = new HashMap<Integer, List<String>>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            List<String> temp = freqVsList.getOrDefault(entry.getValue(), new ArrayList<String>());
            temp.add(entry.getKey());
            freqVsList.put(freq, temp);
        }
        for(Map.Entry<Integer, List<String>> entry : freqVsList.entrySet()) {
            freqList.add(entry.getKey());
        }
        Collections.sort(freqList);
        int i = freqList.size()-1;
        int count = 0;
        int currFreq = -1;
        while(count < k && i >= 0) {
            //extract the max freq
            currFreq = freqList.get(i--);
            List<String> temp = freqVsList.get(currFreq);
            Collections.sort(temp);
            if(temp.size() <= k-count) {
                output.addAll(temp);
                count += temp.size();
            } else {
                for(int j=0; j<temp.size() && count<k; j++) {
                    output.add(temp.get(j));
                    count++;
                }
            }
        }
        return output;
    }

}

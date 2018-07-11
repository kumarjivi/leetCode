package problems301to350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * @author jivi
 *
 */
public class TopKFrequentElements347 {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int k = 2;
		List<Integer> output = topKFrequent(arr, k);
		output.forEach(x -> System.out.print(x+" "));
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> output = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> elementFreqMap = new HashMap<Integer, Integer>();
        int maxFreq = 0;
        for(int num : nums) {
            elementFreqMap.put(num, elementFreqMap.getOrDefault(num, 0)+1);
            maxFreq = Math.max(maxFreq, elementFreqMap.get(num));
        }
        List<Integer>[] bucket = new List[maxFreq];
        for(Map.Entry<Integer, Integer> entry : elementFreqMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            List<Integer> list = new ArrayList<Integer>();
            if(bucket[freq-1] != null) {
                list = bucket[freq-1];
            }
            list.add(element);
            bucket[freq-1] = list;
        }
        
        int count = 0, i = maxFreq-1;
        while(count < k && i >= 0) {
            if(bucket[i] != null) {
                List<Integer> elements = bucket[i];
                if(elements.size() < k-count) {
                    output.addAll(elements);
                    count += elements.size();
                } else {
                    for(int element : elements) {
                        output.add(element);
                        count++;
                        if(count == k) {
                            break;
                        }
                    }
                }
            }
            i--;
        }
        return output;
    }
}

package problems851to900;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdvantageShuffle870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,0,4,1,2};
		int[] B = {1,3,0,0,2};
		int[] ans = advantageCount(A, B);
		for(int i : ans) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] advantageCount(int[] A, int[] B) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Map<Integer, List<Integer>> mapB = new TreeMap<Integer, List<Integer>>();
        for(int i=0; i<B.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if(mapB.containsKey(B[i])) {
                list = mapB.get(B[i]);
            }
            list.add(i);
            mapB.put(B[i], list);
        }
        Iterator<Map.Entry<Integer, List<Integer>>> itr = mapB.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer, List<Integer>> entry = itr.next();
            int key = entry.getKey();
            Integer val = map.higherKey(key);
            if(val == null) {
                val = map.firstKey();
            }
            //
            int index = entry.getValue().get(0);
            if(entry.getValue().size() == 1) {
                itr.remove();
            } else {
            	List<Integer> temp = entry.getValue();
            	temp.remove(0);
            	entry.setValue(temp);
            	itr = mapB.entrySet().iterator();
            }
            //
            A[index] = val.intValue();
            if(map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val)-1);
            }
        }
        return A;
    }

}

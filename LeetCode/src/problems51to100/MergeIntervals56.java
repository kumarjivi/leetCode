package problems51to100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/***
 * Given a collection of intervals, merge all overlapping intervals.
 * @author jivi
 *
 */
public class MergeIntervals56 {
	static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	public static void main(String[] args) {
		Interval one = new Interval(1,3);
		Interval two = new Interval(2,6);
		Interval three = new Interval(8,10);
		Interval four = new Interval(15,18);
		List<Interval> list = new ArrayList<Interval>();
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		List<Interval> output = merge(list);
		output.forEach(s -> System.out.print(s.start +"-" +s.end+" "));
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
           @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for(int i=0; i<intervals.size()-1; i++) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i+1);
            if(curr.start == next.start || curr.end >= next.start) {
                curr.end = Math.max(curr.end, next.end);
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;
    }

}

package problems851to900;

import java.util.ArrayList;
import java.util.List;

public class ExamRoom855 {
    List<Integer> occupiedList;
    int size = 0;
    public ExamRoom855(int N) {
        occupiedList = new ArrayList<Integer>();
        size = N;
    }
    
    public int seat() {
        int seatNum = getOptimalSeat();
        if(seatNum == -1) {
            return -1;
        } else {
            putSorted(seatNum);
        }
        return seatNum;
    }
    
    private void putSorted(int val) {//0
        if(occupiedList.size() == 0 || val > occupiedList.get(occupiedList.size()-1)) {
            occupiedList.add(val);
            return;
        }
        for(int i=0; i<occupiedList.size(); i++) {
            if(val < occupiedList.get(i)) {
                occupiedList.add(i, val);
                break;
            }
        }
    }

    private int getOptimalSeat() {
        if(occupiedList.isEmpty()) {
            return 0;
        } else if(occupiedList.size() == size) {
            return -1;
        }
        int maxDistance = 0;
        int seatNum = -1;
        int start = -1;
        int thisDistance=0;
        int index = -1;
        for(int i : occupiedList) {
        	index = -1;
            if(start == -1) {
            	if(i != 0) {
            		index = 0;
            		thisDistance = i;
            	} else {
            		start = i;
            		continue;
            		//do nothing.
            	}
            } else {
            	index = (start + i)/2;
            	thisDistance = Math.min(index-start, i-index);
            }
            if(thisDistance > maxDistance) {
            	maxDistance = thisDistance;
            	seatNum = index;
            }
            start = i;
        }
        if(start != size-1) {
        	index = size-1;
        	thisDistance = index-start;
        	if(thisDistance > maxDistance) {
        		seatNum = index;
        	}
        }
        return seatNum;
    }
    
    public void leave(int p) {
        int index = occupiedList.indexOf(p);
        if(index != -1) {
            occupiedList.remove(index);
        }
        
    }
}

/**
 * Your ExamRoom855 object will be instantiated and called as such:
 * ExamRoom855 obj = new ExamRoom855(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
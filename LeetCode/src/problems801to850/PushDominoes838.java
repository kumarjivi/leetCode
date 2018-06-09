package problems801to850;

public class PushDominoes838 {
	
	StringBuilder sb = null;
    public String pushDominoes(String dominoes) {
        sb = new StringBuilder(dominoes);
        helper(sb, 0);
        return sb.toString();
    }
    
    public void helper(StringBuilder str, int startIndex) {
        if(startIndex >= str.length()) return;
        
        int firstIndex = getFirstIndexNonDot(str, startIndex);
        if(firstIndex == -1) return;
        char ch = str.charAt(firstIndex);
        if(ch == 'L') {
            makeItLOrR(str, startIndex, firstIndex, 'L');
            helper(str, firstIndex+1);
        } else {//char is 'R'
            //find the next non-dot char.
            int nextIndex = getFirstIndexNonDot(str, firstIndex+1);
            if(nextIndex == -1) {
            	makeItLOrR(str, firstIndex+1, str.length()-1, 'R');
            	return;
            }
            if(str.charAt(nextIndex) == 'L') {
                //drop one by one.
                int r = firstIndex;
                int l = nextIndex;
                while(r < l) {
                    str.setCharAt(r, 'R');;
                    str.setCharAt(l,'L');
                    r++;
                    l--;
                }
                helper(str, nextIndex+1);
                
            } else {//next char is 'R'
                //change everything from firstIndex to nextIndex by 'R'
                makeItLOrR(str, firstIndex, nextIndex, 'R');
                helper(str, nextIndex);
            }
        }
    }
	public int getFirstIndexNonDot(StringBuilder str, int i) {
        for(int j = i; j< str.length(); j++) {
            if(str.charAt(j) == 'L' || str.charAt(j) == 'R') {
                return j;
            }
        }
        return -1;
    }
    
	/**
	 * from index startIndex to index endIndex, make every character in the StringBuilder sb as char ch.
	 * @param sb
	 * @param startIndex
	 * @param endIndex
	 * @param ch
	 */
    public void makeItLOrR(StringBuilder sb, int startIndex, int endIndex, char ch) {
        for(int i=startIndex; i<=endIndex; i++) {
            sb.setCharAt(i, ch);
        }
    }
}
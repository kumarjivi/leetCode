package problems51to100;
/***
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * 	1. Insert a character
 * 	2. Delete a character
 * 	3. Replace a character
 * @author jivi
 *
 */
public class EditDistance72 {
	int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()+1][word2.length()+1];
        //fill first row.
        for(int j=0; j<memo[0].length; j++) {
            memo[0][j] = j;
        }
        //fill first column.
        for(int i=0; i<memo.length; i++) {
            memo[i][0] = i;
        }
        //can use bottom-up or top-down
        helperTopDown(word1, word1.length(), word2, word2.length());
        //helperBottomUp(word1, word2);
        return memo[word1.length()][word2.length()];
    }
    
    public int helperTopDown(String one, int i, String two, int j) {
        if(i==0) {
            return j;
        }
        if(j==0) {
            return i;
        }
        if(memo[i][j] == 0){
            int add = Integer.MAX_VALUE, rem = Integer.MAX_VALUE, repl = Integer.MAX_VALUE;
            add = 1 + helperTopDown(one, i, two, j-1);
            rem = 1 + helperTopDown(one, i-1, two, j);
            repl = helperTopDown(one, i-1, two, j-1);
            if(one.charAt(i-1) != two.charAt(j-1)) {
                repl++;
            }
            memo[i][j] = Math.min(add, Math.min(rem, repl));
        }    
        return memo[i][j];
    }
    
    public void helperBottomUp(String one, String two) {
        int len1 = one.length();
        int len2 = two.length();
        for(int i=1; i<=len1; i++) {
            for(int j=1; j<=len2; j++) {
                int repl = memo[i-1][j-1];
                if(one.charAt(i-1) != two.charAt(j-1)) {
                    repl++;
                }
                memo[i][j] = Math.min(memo[i-1][j]+1, Math.min(memo[i][j-1]+1, repl));
            }
        }
    }
}

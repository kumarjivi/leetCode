package problems651to700;

import commonStruct.TreeNode;

public class LongestUnivaluePath687 {
	int longestUnivaluePath = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return longestUnivaluePath;
    }
    
    private int helper(TreeNode node) {
        int lUniVal = 0;
        int rUniVal = 0;
        if(node != null) {
            boolean leftPresent = node.left != null;
            boolean rightPresent = node.right != null;
            lUniVal = helper(node.left);
            rUniVal = helper(node.right);
            int left = 0, right = 0;
            if(leftPresent && node.val == node.left.val) {
                left = 1 + lUniVal;
            }
            if(rightPresent && node.val == node.right.val) {
                right = 1 + rUniVal;
            }
            if(longestUnivaluePath < left + right) {
                longestUnivaluePath = left + right;
            }
            return Math.max(left, right);
        } else {
            return 0;
        }
        
    }
}

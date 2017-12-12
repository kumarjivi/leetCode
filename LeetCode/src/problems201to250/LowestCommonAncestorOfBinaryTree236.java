package problems201to250;

import commonStruct.TreeNode;

public class LowestCommonAncestorOfBinaryTree236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if( root.val == q.val) {
            return q;
        } else if (root.val == p.val) {
            return p;
        } else {
            //if p, q are on lhs of root, root = root.left
            if(isContained(root.left, p) && isContained(root.left, q)) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (isContained(root.right, p) && isContained(root.right, q)) {//if p, q are on rhs of root, root = root.right
                return lowestCommonAncestor(root.right, p, q);
            } else {//if p, q are on different sides of root, if yes, return root.
                return root;
            }            
        }
    }
    
    private boolean isContained(TreeNode root, TreeNode p) {
        if(root == null) {
            return false;
        } else if(root.val == p.val) {
            return true;
        } else {
            return isContained(root.left, p) || isContained(root.right, p);
        }
    }
}

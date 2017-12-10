package problems501to550;

import commonStruct.TreeNode;

public class DiameterOfBinaryTree543 {
    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int thisDiameter = 0;
            if(root.left != null) {
                thisDiameter = 1 + getMaxPath(root.left);
            }
            if(root.right != null) {
                thisDiameter += 1 + getMaxPath(root.right);
            }
            if(maxPath < thisDiameter) {
                maxPath = thisDiameter;
            }
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
        }
        return maxPath;

    }
    //root should not be null.
    private int getMaxPath(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        } else {
            int lPath = 0;
            int rPath = 0;
            if(root.left != null) {
                lPath = getMaxPath(root.left);
            }
            if(root.right != null) {
                rPath = getMaxPath(root.right);
            }
            return 1 + Math.max(lPath, rPath);
        }
    }
}

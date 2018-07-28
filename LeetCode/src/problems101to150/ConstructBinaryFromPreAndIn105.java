package problems101to150;

import commonStruct.TreeNode;

public class ConstructBinaryFromPreAndIn105 {
	int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int pe=preorder.length-1;
        int ps=0;
        int is=0;
        int ie=inorder.length-1;
        pre = preorder;
        in = inorder;
        TreeNode root = helper(ps, is, ie);
        return root;
    }
    
    
    private TreeNode helper(int ps, int is, int ie) {
        if(is > ie) {
            return null;
        } else {
            int ind = 0;//get index of pre[ps] in in[] between indices is and ie.
            if(ps >= pre.length) {
                return null;
            }
            ind = getIndexOf(in, is, ie, pre[ps]);
            if(ind != -1) {
                TreeNode node = new TreeNode(pre[ps]);
                node.left = helper(ps+1, is, ind-1);
                node.right = helper(ps+(ind-is)+1, ind+1, ie);
                return node;
            } else {
                return null;
            }
        }
    }
    
    private int getIndexOf(int[] arr, int startIndex, int endIndex, int target) {
        if(arr==null || arr.length == 0 || startIndex < 0 || endIndex >= arr.length) {
            return -1;
        }
        for(int i=startIndex; i<=endIndex; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

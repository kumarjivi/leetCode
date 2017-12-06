package problems400to450;

import commonStruct.TreeNode;

public class DeleteNodeInABst450 {
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
	        return root;
	    if(root.val < key) {
	        root.right = deleteNode(root.right, key);
	        //return root;
	    } else if (root.val > key) {
	        root.left = deleteNode(root.left, key);
	        //return root;
	    } else {
	        /*if(root.left == null && root.right == null) {
	            return null;
	        } else */if(root.left == null) {
	            return root.right;
	        } else if(root.right == null) {
	            return root.left;
	        } else {
	            root.val = findInorderSuccessor(root.right).val;
	            root.right = deleteNode(root.right, root.val);
	        }
	        //return root;
	    }
	    return root;
    }
    
    private TreeNode findInorderSuccessor(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    } 
}

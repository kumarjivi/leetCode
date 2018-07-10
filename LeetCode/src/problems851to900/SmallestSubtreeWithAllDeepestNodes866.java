package problems851to900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import commonStruct.TreeNode;
/***
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.
 * @author jivi
 *
 */
public class SmallestSubtreeWithAllDeepestNodes866 {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.left = two; one.right = three;
		TreeNode ans = subtreeWithAllDeepest(one);
		if(ans == null) {
			System.out.println("null");			
		} else {
			System.out.println(ans.val);
		}
		
	}
	
	static Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return root;
        }
        List<TreeNode> pri = new ArrayList<TreeNode>();
        List<TreeNode> sec = new ArrayList<TreeNode>();
        pri.add(root);
        
        while(!pri.isEmpty()) {
            for(int i=0; i<pri.size(); i++) {
                TreeNode node = pri.get(i);
                if(node.left != null) {
                    sec.add(node.left);
                    map.put(node.left, node);
                }
                if(node.right != null) {
                    sec.add(node.right);
                    map.put(node.right, node);
                }
            }
            if(sec.isEmpty()) {
                sec.addAll(pri);
                pri.clear();
            } else {
                pri.clear();
                pri.addAll(sec);
                sec.clear();
            }
        }
        //sec has the deepest nodes
        Set<TreeNode> set = new HashSet<TreeNode>();
        set.addAll(sec);
        sec.clear();
        while(set.size() != 1) {
            sec.addAll(set);
            set.clear();
            while(!sec.isEmpty()) {
                TreeNode node = sec.remove(0);
                if(node != root) {
                    set.add(map.get(node));
                }
            }
        }
        return set.iterator().next();
    }

}

package problems201to250;

import commonStruct.TreeNode;

public class LowestCommonAncestorOfBinaryTree236Test {

	public static void main(String[] args) {
		LowestCommonAncestorOfBinaryTree236 test = new LowestCommonAncestorOfBinaryTree236();
		TreeNode a = new TreeNode(37);
		TreeNode b = new TreeNode(-34);
		TreeNode c = new TreeNode(-48);
		TreeNode g = new TreeNode(48);
		TreeNode e = new TreeNode(-100);
		TreeNode f = new TreeNode(-100);
		TreeNode m54 = new TreeNode(-54);
		TreeNode m71 = new TreeNode(-71);
		TreeNode m22 = new TreeNode(-22);
		TreeNode p8 = new TreeNode(8);
		g.left = m54;
		m54.left = m71;
		m54.right = m22;
		m22.right = p8;
		a.left = b;
		a.right = c;
		//b.left = d;
//		b.right = e;
//		c.left = f;
//		c.right = g;
//		e.left = h;
//		e.right = i;
		TreeNode output = test.lowestCommonAncestor(a, e, f);
		System.out.println(output.val);
	}

}

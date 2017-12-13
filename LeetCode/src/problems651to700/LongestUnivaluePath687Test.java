package problems651to700;

import commonStruct.TreeNode;

public class LongestUnivaluePath687Test {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(1);
		a.right = b;
		b.left = c;
		a.left = d;
		d.left = e;
		d.right = f;
		LongestUnivaluePath687 test = new LongestUnivaluePath687();
		int output = test.longestUnivaluePath(a);
		System.out.println(output);
	}

}

package problems101to150;

import commonStruct.TreeNode;

public class ConstructBinaryFromPreAndIn105Test {

	public static void main(String[] args) {
		ConstructBinaryFromPreAndIn105 obj = new ConstructBinaryFromPreAndIn105();
		int[] pre = {5,6,8,13,1,9,2,3,7,10,4,15,12,17,18};
		int[] in = {13,8,1,6,2,9,3,5,4,10,15,7,17,12,18};
		TreeNode root = obj.buildTree(pre, in);
		System.out.println("Done!");
	}

}

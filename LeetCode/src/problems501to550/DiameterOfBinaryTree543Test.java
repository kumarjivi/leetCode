package problems501to550;

import commonStruct.TreeNode;

public class DiameterOfBinaryTree543Test {
    public static  void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        //one.right = three;
        two.left = four;
//        two.right = five;
        DiameterOfBinaryTree543 diameterOfBinaryTree543 = new DiameterOfBinaryTree543();
        int output = diameterOfBinaryTree543.diameterOfBinaryTree(one);
        System.out.println("out:"+output);
    }


}

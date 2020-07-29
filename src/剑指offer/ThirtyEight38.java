package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/23
 * @Time:16:55
 * @description:
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 */
public class ThirtyEight38 {

    public static void main(String[] args) {

//        TreeNode root1 = new TreeNode(8);
//        root1.left = new TreeNode(8);
//        root1.right = new TreeNode(7);
//        root1.left.left = new TreeNode(9);
//        root1.left.right = new TreeNode(2);
//        root1.left.right.left = new TreeNode(4);
//        root1.left.right.right = new TreeNode(7);
//
//        System.out.println(TreeDepth(root1));


    }



    public  int TreeDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        int nLeft = TreeDepth(root.left)+1;
        int nRight = TreeDepth(root.right)+1;
        return nLeft>nRight?nLeft:nRight;

    }




    public  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }



}

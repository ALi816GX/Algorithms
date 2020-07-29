package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/23
 * @Time:16:56
 * @description:
 *
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树（Balanced Binary Tree）又被称为AVL树（有别于AVL算法），
 * 且具有以下性质：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树
 */
public class ThirtyNine39 {


    public boolean IsBalanced_Solution(TreeNode root) {

        if(root == null){
            return true;
        }

        return IsBalanced(root)&&IsBalanced(root.left)&&IsBalanced(root.right);

    }

    public static Boolean IsBalanced(TreeNode root){
        if(root == null){
            return  true;
        }else {
            int nleft = TreeDepth(root.left);
            int nright = TreeDepth(root.right);
            return Math.abs(nleft-nright)<=1?true:false;
        }
    }

    public static int TreeDepth(TreeNode root) {

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

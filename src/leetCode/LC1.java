package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/10/2
 * @Time:16:12
 * @description:
 *
 * 给定二叉树，找到它的最小深度。
 * 最小深度是沿从根节点到最近的
 * 叶节点的最短路径上的节点数。
 *
 */
public class LC1 {


    public static void main(String[] args) {


        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
//        t1.left = t2;


        System.out.println(run(t1));


    }


    private static int min = 1;

    public static int run(TreeNode root) {

        if(root == null){
            return 0;
        }

        getMin(min,root);

        return min;
    }


    private static void getMin(int index,TreeNode root){

        if(root == null){
           if(index == 2){
                min = index;
           }
           else if(index > 2){
               if(index < min){
                   min = index;
               }
           }
        }
        else {

            if(root.left == null){
                getMin(index,root.left);
            }
            else {
                getMin(index+1,root.left);
            }


            if(root.right == null){
                getMin(index,root.right);
            }
            else {
                getMin(index+1,root.right);
            }

        }

    }



    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

//
//    public int run(TreeNode root) {
//        if(root==null)
//            return 0;
//        if(root.left==null)
//            return run(root.right)+1;
//        if(root.right==null)
//            return run(root.left)+1;
//        return Math.min(run(root.left),run(root.right))+1;
//    }

}

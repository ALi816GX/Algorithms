package jzOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/23
 * @Time:20:30
 * @description:
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 */
public class TwentyTwo22 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        ArrayList<Integer> cc = PrintFromTopToBottom(root1);

        for(Integer a : cc){
            System.out.println(a);
        }

    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);      //相当于add 入列

        BreadFirstSearch(arrayList,queue);

        return arrayList;

    }



    public static void BreadFirstSearch(ArrayList<Integer> arrayList,Queue<TreeNode> queue){


        while(!queue.isEmpty()){

            TreeNode head = queue.poll();     //相对于remove 出列

            arrayList.add(head.val);

            if(head.left!=null){
                queue.offer(head.left);     //左子树入列
            }
            if(head.right!=null){
                queue.offer(head.right);     //右子树入列
            }

        }

    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}

package 剑指offer;

import java.util.*;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:17:13
 * @description:
 *
 *
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 */
public class FiftyNine59 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Print(t1);

    }


    private static Queue<TreeNode> queue = new LinkedList<>();

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {



        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot == null){
            return result;
        }

        queue.clear();
        queue.add(pRoot);

        int judge = 0;
        while(!queue.isEmpty()){


            ArrayList<Integer> arrayList = new ArrayList<>();
            Iterator<TreeNode> iterator = queue.iterator();
            while (iterator.hasNext()){
                arrayList.add(iterator.next().val);
            }

            if(judge%2 == 1){
                Collections.reverse(arrayList);
            }
            result.add(arrayList);

            int size = queue.size();
            for(int i = 0;i < size;i++){
                widePrint();
            }

            judge++;
        }


        return result;


    }

    private static void widePrint(){
        TreeNode temp =  queue.poll();
        if(temp.left!=null){
            queue.add(temp.left);
        }
        if(temp.right!=null){
            queue.add(temp.right);
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

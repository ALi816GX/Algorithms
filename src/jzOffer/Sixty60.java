package jzOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:18:08
 * @description:
 *
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 */
public class Sixty60 {



    private static Queue<TreeNode> queue = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


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


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}

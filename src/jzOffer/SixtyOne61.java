package jzOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:23:13
 * @description:
 *
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 思路：前序输出，则前序输出的字符串 - 》 构建 二叉树。
 *
 */
public class SixtyOne61 {


    String Serialize(TreeNode root) {
        if (root==null)
            return "#,";
        StringBuilder sb = new StringBuilder(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        Queue<String> q = new LinkedList<>();
        for (int i=0;i<strs.length;i++){
            q.add(strs[i]);
        }
        return PreOrder(q);
    }

    TreeNode PreOrder(Queue<String> q){
        String val = q.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = PreOrder(q);
        node.right = PreOrder(q);
        return node;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}

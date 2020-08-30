package leetCode;

import jzOffer.JZ22;
import jzOffer.JZ39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/16
 * @Time:17:46
 * @description: 给定一个二叉树，返回该二叉树由底层到顶层的层序遍历，（从左向右，从叶子节点到根节点，一层一层的遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * 3↵   / ↵  9  20↵    /  ↵   15   7
 * 该二叉树由底层到顶层层序遍历的结果是
 * [↵  [15,7]↵  [9,20],↵  [3],↵]
 * 如果你不清楚“{1,#,2,3}"的含义的话，请继续阅读
 * OJ用这样的方法将二叉树序列化：
 * 二叉树的序列化遵循层序遍历的原则，”#“代表该位置是一条路径的终结，
 */
public class LC42 {

    public static void main(String[] args) {
        LC42 lc42 = new LC42();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        System.out.println(lc42.levelOrderBottom(root1));
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        wideSearch(result, queue);
        return result;
    }

    private void wideSearch(ArrayList<ArrayList<Integer>> result, Queue<TreeNode> queue) {
        while (!queue.isEmpty()) {
            ArrayList<Integer> one = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                one.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, one);
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

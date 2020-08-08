package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/8
 * @Time:17:02
 * @description: 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 */
public class LC37 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(11);
        treeNode.right.right = new TreeNode(9);
        LC37 lc37 = new LC37();
        System.out.println(lc37.pathSum(treeNode, 22).toString());
    }

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getRoute(result, new ArrayList<Integer>(), root, sum);
        return result;
    }

    public void getRoute(ArrayList<ArrayList<Integer>> listRoute, ArrayList<Integer> currentList, TreeNode root, int sum) {
        if (root != null) {
            currentList.add(root.val);
            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();
            leftList.addAll(currentList);
            rightList.addAll(currentList);
            if (root.left == null && root.right == null && getSum(currentList) == sum) {
                listRoute.add(currentList);
            }
            getRoute(listRoute, leftList, root.left, sum);
            getRoute(listRoute, rightList, root.right, sum);
        }
    }

    public int getSum(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
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

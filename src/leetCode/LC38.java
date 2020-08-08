package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/9
 * @Time:00:14
 * @description: 给定一个二叉树和一个值\ sum sum，判断是否有从根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 * <p>
 * 返回true，因为存在一条路径 5\to 4\to 11\to 25→4→11→2的节点值之和为 22
 */
public class LC38 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(11);
        treeNode.right.right = new TreeNode(9);
        LC38 lc38 = new LC38();
        System.out.println(lc38.hasPathSum(treeNode, 22));
    }

    /*
     * public class TreeNode {
     *   int val = 0;
     *   TreeNode left = null;
     *   TreeNode right = null;
     * }
     */

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getRoute(result, new ArrayList<Integer>(), root, sum);
        return !result.isEmpty();
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


package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/22
 * @Time:15:14
 * @description:
 */
public class LC44 {


    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static void main(String[] args) {
        LC44 lc44 = new LC44();
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3};
        TreeNode result = lc44.buildTree(preorder, inorder);
        System.out.println(result);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        TreeNode root = new TreeNode(0);
        buildTreeByList(root, preorder, inorder);
        return root;
    }

    public void buildTreeByList(TreeNode root, int[] preorder, int[] inorder) {
        if (root != null && preorder.length != 0) {
            root.val = preorder[0];
            Map<String, int[][]> childs = buildLeftAndRight(preorder, inorder);
            int[][] left = childs.get(LEFT);
            int[][] right = childs.get(RIGHT);
            if (left[0].length != 0) {
                root.left = new TreeNode(0);
                buildTreeByList(root.left, left[0], left[1]);
            }
            if (right[0].length != 0) {
                root.right = new TreeNode(0);
                buildTreeByList(root.right, right[0], right[1]);
            }
        }
    }

    public Map<String, int[][]> buildLeftAndRight(int[] preorder, int[] inorder) {
        Map<String, int[][]> map = new HashMap();
        int[][] left = new int[2][0];
        int[][] right = new int[2][0];
        if (preorder.length == 1) {
            map.put(LEFT, left);
            map.put(RIGHT, right);
            return map;
        }
        int index = 0;
        int root = preorder[0];
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        left[0] = Arrays.copyOfRange(preorder, 1, index + 1);
        left[1] = Arrays.copyOfRange(inorder, 0, index);
        right[0] = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        right[1] = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        map.put(LEFT, left);
        map.put(RIGHT, right);
        return map;
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

package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/15
 * @Time:16:31
 * @description:
 */
public class LC51 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Boolean> list = new ArrayList<>();
        isValid(root, list);
        boolean result = true;
        for (Boolean aBoolean : list) {
            result = result && aBoolean;
        }
        return result;
    }

    public void isValid(TreeNode root, List<Boolean> isNodeValid) {
        if (root != null) {
            boolean result = true;
            if (root.left != null && root.val <= root.left.val) {
                result = false;
            }
            if (root.right != null && root.val >= root.right.val) {
                result = false;
            }
            isNodeValid.add(result);
            isValid(root.left, isNodeValid);
            isValid(root.right, isNodeValid);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}

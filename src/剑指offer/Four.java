package 剑指offer;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/16
 * @Time:20:08
 * @description:
 *
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class Four {

    public static void main(String[] args) {




    }


    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        if( pre == null || in == null || pre.length == 0){
            return null;
        }

        int root_value = pre[0];
        int root_in_index = 0;
        TreeNode root = null;

        for(int i = 0;i < in.length;i++){
            if(root_value == in[i]){
                root = new TreeNode(root_value);
                root_in_index = i;
                break;
            }
        }


        //创建左子树

        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre,1,root_in_index+1),
                Arrays.copyOfRange(in,0,root_in_index)
        );

        //创建右子树

        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre,root_in_index+1,pre.length),
                Arrays.copyOfRange(in,root_in_index+1,in.length)
        );


        return root;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

    }

}

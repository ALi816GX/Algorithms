package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/19
 * @Time:18:10
 * @description:
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 */
public class JZ17 {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(HasSubtree(root1,root2));

    }



        public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if(root1==null||root2==null){
                return false;
            }
            return isSubtree(root1,root2)||isSubtree(root1.left,root2)||isSubtree(root1.right,root2);
        }

        public static boolean isSubtree(TreeNode root1,TreeNode root2) {
            if (root2 == null) {
                return true;
            }
            if (root1 == null) {
                return false;
            }
            if (root1.val == root2.val) {
                return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
            } else {
                return false;
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



//链接：https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88
//        来源：牛客网
//
//public class Solution {
//    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        boolean result = false;
//        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
//        if (root2 != null && root1 != null) {
//            //如果找到了对应Tree2的根节点的点
//            if(root1.val == root2.val){
//                //以这个根节点为为起点判断是否包含Tree2
//                result = doesTree1HaveTree2(root1,root2);
//            }
//            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
//            if (!result) {
//                result = HasSubtree(root1.left,root2);
//            }
//
//            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
//            if (!result) {
//                result = HasSubtree(root1.right,root2);
//            }
//        }
//        //返回结果
//        return result;
//    }
//
//    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
//        //如果Tree2已经遍历完了都能对应的上，返回true
//        if (node2 == null) {
//            return true;
//        }
//        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
//        if (node1 == null) {
//            return false;
//        }
//        //如果其中有一个点没有对应上，返回false
//        if (node1.val != node2.val) {
//            return false;
//        }
//
//        //如果根节点对应的上，那么就分别去子节点里面匹配
//        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
//    }






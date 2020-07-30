package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/25
 * @Time:17:01
 * @description:
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 */
public class JZ26 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(11);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(13);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(14);

        Convert(treeNode);



    }

    static TreeNode head = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null){
            return null;
        }

        head = new TreeNode(0);
        TreeNode oldHead = head;
        ToList(pRootOfTree);        //建立单链表


        //逆向链表
        TreeNode invert = oldHead;
        TreeNode pre;
        while(invert.right != null){
            pre = invert;
            invert.right.left = pre;
            invert = invert.right;
        }

        oldHead.right.left = null;

        return oldHead.right;

    }




    public static void ToList(TreeNode pRootOfTree){

        if(pRootOfTree.left != null){
            ToList(pRootOfTree.left);
        }

        head.right = pRootOfTree;
        head = head.right;

        if(pRootOfTree.right != null){
            ToList(pRootOfTree.right);
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

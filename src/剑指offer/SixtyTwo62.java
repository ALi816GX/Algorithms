package 剑指offer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:18:16
 * @description:
 *
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 */
public class SixtyTwo62 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(KthNode(t1,4).val);
    }


    private static ArrayList<TreeNode> arrayList = new ArrayList<>();

    static TreeNode KthNode(TreeNode pRoot, int k) {


        if(k == 0){
            return null;
        }

        arrayList.clear();

        MidPrint(pRoot);

        if(k > arrayList.size()){
            return null;
        }

        return arrayList.get(k-1);



    }


    private static void MidPrint(TreeNode pRoot){

        if(pRoot != null){

            if(pRoot.left != null){

                MidPrint(pRoot.left);

            }

            arrayList.add(pRoot);

            if(pRoot.right != null){

                MidPrint(pRoot.right);

            }

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

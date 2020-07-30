package jzOffer;


/**
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class JZ58 {

    public static void main(String[] args) {

    }


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return pRoot != null && isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return isSame(left.left, right.right) && isSame(left.right, right.left);
            }
        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}


//public class FiftyEight58 {
//
//    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(8);
//        TreeNode t2 = new TreeNode(6);
//        TreeNode t3 = new TreeNode(10);
//        TreeNode t4 = new TreeNode(5);
//        TreeNode t5 = new TreeNode(7);
//        TreeNode t6 = new TreeNode(9);
//        TreeNode t7 = new TreeNode(11);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
//
//        isSymmetrical(t1);
//
//    }
//
//    private static List<TreeNode> mid_old = new ArrayList<>();
//    private static List<TreeNode> mid_newMirrors = new ArrayList<>();
//
//    static boolean  isSymmetrical(TreeNode pRoot) {
//
//        mid_old.clear();
//        mid_newMirrors.clear();
//
//        midPrint(0,pRoot);
//        TreeNode temp = pRoot;
//        getMirrorRoot(temp);
//        midPrint(1,pRoot);
//
//        for(int i = 0;i < mid_old.size();i++){
//            if(mid_old.get(i).val != mid_newMirrors.get(i).val){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//    private static void getMirrorRoot(TreeNode pRoot){
//
//        if(pRoot != null){
//
//            TreeNode temp = pRoot.right;
//            pRoot.right = pRoot.left;
//            pRoot.left = temp;
//
//            if(pRoot.left != null){
//                getMirrorRoot(pRoot.left);
//            }
//
//            if(pRoot.right != null){
//                getMirrorRoot(pRoot.right);
//            }
//
//        }
//    }
//
//    private static void midPrint(int num ,TreeNode pNode){
//        if(pNode != null){
//            if(pNode.left != null){
//                midPrint(num,pNode.left);
//            }
//            if(num == 0) {
//                mid_old.add(pNode);
//            }else {
//                mid_newMirrors.add(pNode);
//            }
//            if(pNode.right != null){
//                midPrint(num,pNode.right);
//            }
//        }
//    }
//
//
//
//    public static class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(int val) {
//            this.val = val;
//
//        }
//
//    }
//}




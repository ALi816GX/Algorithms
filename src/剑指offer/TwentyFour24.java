package 剑指offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/25
 * @Time:12:06
 * @description:
 *
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 */
public class TwentyFour24 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(14);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        FindPath(root1,22);

        for(ArrayList<Integer> a:targetList){
            for(int b:a){
                System.out.print(b);
            }
            System.out.println();
        }
        
    }

    static ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> targetList = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root == null){
            return new ArrayList<>();
        }

        totalList.clear();
        targetList.clear();

        ArrayList<Integer> list = new ArrayList<>();
        AllPath(list,root);

        for(ArrayList<Integer> a:totalList){
            int total = 0;
            for(int b:a){
                total+=b;
            }
            if(total == target){
                targetList.add(a);
            }
        }

        //自定义Comparator对象，自定义排序
        Comparator c = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()<o2.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        };

        //排序
        targetList.sort(c);
        

        return targetList;

    }


    public static void AllPath(ArrayList<Integer> list,TreeNode root){
        list.add(root.val);
        totalList.add(list);

        if(root.left != null){
            ArrayList<Integer> list1 = new ArrayList<>();
            for(Integer a:list){
                list1.add(a);
            }
            totalList.remove(list);
            AllPath(list1,root.left);
        }

        if(root.right != null){
            ArrayList<Integer> list2 = new ArrayList<>();
            for(Integer a:list){
                list2.add(a);
            }
            totalList.remove(list);
            AllPath(list2,root.right);
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

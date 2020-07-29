package jzOffer;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class FiftySeven57 {


    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(8);
        TreeLinkNode t2 = new TreeLinkNode(6);
        TreeLinkNode t3 = new TreeLinkNode(10);
        TreeLinkNode t4 = new TreeLinkNode(5);
        TreeLinkNode t5 = new TreeLinkNode(7);
        TreeLinkNode t6 = new TreeLinkNode(9);
        TreeLinkNode t7 = new TreeLinkNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t2.next = t1;
        t3.next = t1;
        t4.next = t2;
        t5.next = t2;
        t6.next = t3;
        t7.next = t3;

        System.out.println(GetNext(t7).val);
    }

    private static List<TreeLinkNode> list = new ArrayList<>();

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {


        list.clear();

        TreeLinkNode head = getHead(pNode);
        midPrint(head);
        int i = 0;
        for(;i < list.size();i++){
            if(list.get(i) == pNode){
                break;
            }
        }

        if(i == list.size() - 1){

            return null;

        }else {

            return list.get(i + 1);

        }
    }

    private static TreeLinkNode getHead(TreeLinkNode pNode){
        while(pNode != null){
            if(pNode.next == null){
                return pNode;
            }else {
                pNode = pNode.next;
            }
        }
        return pNode;
    }


    private static void midPrint(TreeLinkNode pNode){
        if(pNode != null){
            if(pNode.left != null){
                midPrint(pNode.left);
            }
            list.add(pNode);
            if(pNode.right != null){
                midPrint(pNode.right);
            }
        }
    }




    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}

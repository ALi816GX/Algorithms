package jzOffer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/16
 * @Time:15:55
 * @description:
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */


public class JZ3 {


    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode head = null;
        ListNode tempnextNode;

        while (listNode != null){

            tempnextNode = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = tempnextNode;

        }

        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        return list;

    }



    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}

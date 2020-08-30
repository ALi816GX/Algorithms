package leetCode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/22
 * @Time:16:30
 * @description:
 */
public class LC66 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        LC66 lc66 = new LC66();
        ListNode listNode = lc66.deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> copy = new TreeSet<>();
        int preNum = -1;
        ListNode secondHead = head;
        while (head != null) {
            if (preNum == head.val) {
                copy.add(head.val);
            }
            preNum = head.val;
            head = head.next;
        }

        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        while (secondHead != null) {
            if (!copy.contains(secondHead.val)) {
                listNode.next = new ListNode(secondHead.val);
                listNode = listNode.next;
            }
            secondHead = secondHead.next;
        }
        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}

package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/19
 * @Time:01:14
 * @description:
 *
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 */
public class Fifteen {

    public ListNode ReverseList(ListNode head) {

        ListNode head_index = null;
        ListNode pre_index;

        while (head != null){
            pre_index = head.next;
            head.next = head_index;
            head_index = head;
            head = pre_index;
        }

        return head_index;

    }


    public class ListNode {

        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }

    }

}

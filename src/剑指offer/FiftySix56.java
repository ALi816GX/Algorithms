package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:03:26
 * @description:
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class FiftySix56 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        deleteDuplication(head);


    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        List<int[]> array = new ArrayList<>();
        while(pHead!=null){
            recordNumTimes(array,pHead.val);
            pHead = pHead.next;
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        for(int[] one:array) {
            if(one[1] == 1){
                ListNode newOne = new ListNode(one[0]);
                temp.next = newOne;
                temp = temp.next;
            }
        }

        return result.next;
    }

    public static void  recordNumTimes(List<int[]> records,int num) {
        if (!records.isEmpty()) {
            int[] one = records.get(records.size() - 1);
            if (one[0] == num) {
                one[1]++;
            }
            else {
                int[] newOne = new int[2];
                newOne[0] = num;
                newOne[1] = 1;
                records.add(newOne);
            }
        }
        else {
            int[] newOne = new int[2];
            newOne[0] = num;
            newOne[1] = 1;
            records.add(newOne);
        }
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

package jzOffer;

import java.util.HashSet;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/6
 * @Time:03:19
 * @description:
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 */
public class JZ55 {


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        HashSet<ListNode> head = new HashSet<>();
        while(pHead!=null){
            if(!head.contains(pHead)){
                head.add(pHead);
                pHead = pHead.next;
            }
            else {
                return pHead;
            }
        }

        return null;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

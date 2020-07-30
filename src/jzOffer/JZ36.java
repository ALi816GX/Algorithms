package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/22
 * @Time:15:59
 * @description:
 */
public class JZ36 {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {


        ListNode resultNode = null;

        int length1 = getLength(pHead1);

        int length2 = getLength(pHead2);


        ListNode LongList;

        ListNode ShortList;

        int steps = 0;

        if (length1 > length2) {

            LongList = pHead1;

            ShortList = pHead2;

            steps = length1 - length2;

        } else {

            LongList = pHead2;

            ShortList = pHead1;

            steps = length2 - length1;

        }


        for (int i = 0; i < steps; i++) {

            LongList = LongList.next;

        }

        while (LongList != null && ShortList != null && LongList != ShortList) {

            LongList = LongList.next;

            ShortList = ShortList.next;

        }


        resultNode = LongList;

        return resultNode;

    }


    public static int getLength(ListNode listNode){
        int total = 0;
        while(listNode != null){
            total++;
            listNode = listNode.next;
        }
        return total;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}

package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/18
 * @Time:23:51
 * @description:
 */
public class JZ14 {

    public ListNode creatListNode(){
        ListNode newNode = new ListNode(1);
//        newNode.next = new ListNode(2);
//        newNode.next.next = new ListNode(3);
//        newNode.next.next.next = new ListNode(4);
//        newNode.next.next.next.next = new ListNode(5);
        return newNode;
    }

    public static void main(String[] args) {


        ListNode newNode = new JZ14().creatListNode();

        FindKthToTail(newNode,1);
    }

    public static ListNode FindKthToTail(ListNode head,int k) {



        int num = 0;
        ListNode newNode = head;
        ListNode node = null;
        while (head != null){
            System.out.println(head.val);
            if(head.next == null) {
                node = head;
            }
            head = head.next;
            num++;
        }


        if(k>num){
            return null;
        }

        int index = num - k + 1;


        while (index != 1){
            index--;
            System.out.println(newNode.val);
            newNode = newNode.next;
        }


        return newNode;


    }


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

}

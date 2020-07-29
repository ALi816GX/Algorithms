package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/19
 * @Time:14:08
 * @description:
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class SixTeen {


    public ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null ){
            return list2;
        }else if(list2 == null){
            return list1;
        }


        ListNode minest = new ListNode(-10000000);
        minest.next = list1;

        ListNode node;
        ListNode head_index = minest;
        ListNode next_index = list1;


        while (list2 != null){          // 联表2为空则直接返回联表1;

            int judge = 0;              //判断是否插入

            node = list2;
            list2 = list2.next;         // 取出联表2的首个节点

            while (list1 != null){

                if(node.val <= list1.val){      //插入节点
                    node.next = next_index;
                    head_index.next = node;
                    judge = 1;
                    break;
                }

                head_index = next_index;        //  移动指针
                next_index = list1.next;
                list1 = list1.next;

            }

            if(judge == 0){                 //还没插入,则说明比联表所有的都大，插末尾
                head_index.next = node;
            }

            list1 = minest.next;            //指针返回原来的地方
            head_index = minest;
            next_index = list1;

        }

        return minest.next;



    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}

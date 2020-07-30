package jzOffer;

import java.util.HashMap;


/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/25
 * @Time:13:11
 * @description:
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */
public class JZ25 {


    public RandomListNode Clone(RandomListNode pHead){

        HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<>(16);

        RandomListNode oldPhead = pHead;

        RandomListNode firstHead = new RandomListNode(0);

        RandomListNode secondHead = firstHead;

        RandomListNode ResultHead = firstHead;

        while(pHead != null){
            RandomListNode newNode = new RandomListNode(pHead.label);
            hashMap.put(pHead,newNode);
            firstHead.next = newNode;
            pHead = pHead.next;
            firstHead = firstHead.next;
        }

        secondHead = secondHead.next;
        while (oldPhead != null){
            secondHead.random = hashMap.get(oldPhead.random);
            secondHead = secondHead.next;
            oldPhead = oldPhead.next;
        }

        return ResultHead.next;

    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}

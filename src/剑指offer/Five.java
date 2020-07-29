package 剑指offer;

import java.util.Stack;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/17
 * @Time:14:20
 * @description:
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 *
 * 队列中的元素为int类型。
 *
 *
 */

public class Five {

    Stack<Integer> stack1 = new Stack<Integer>();   //  存放入列顺序
    Stack<Integer> stack2 = new Stack<Integer>();   //  存放出列顺序

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack2.empty()){
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }

    }

}

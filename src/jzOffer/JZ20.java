package jzOffer;

import java.util.Stack;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/19
 * @Time:23:50
 * @description:
 *
 *
 * 定义栈的数据结构，请在该类型中实现一个
 * 能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 *
 */
public class JZ20 {


    public static void main(String[] args) {

    }

    private Stack<Integer> data_stack=new Stack<Integer>();
    private Stack<Integer> min_stack=new Stack<Integer>();

    public void push(int node) {

        if(data_stack.empty()){
            data_stack.push(node);
            min_stack.push(node);
        }
        else {

            data_stack.push(node);

            if(data_stack.peek() > min_stack.peek()) {
                    min_stack.push(min_stack.peek());
            }else {
                min_stack.push(data_stack.peek());
            }

        }

    }

    public void pop() {

        if(!data_stack.empty()) {
            data_stack.pop();
            min_stack.pop();
        }

    }

    public int top() {
        if(!min_stack.empty()){
            return min_stack.peek();
        }
        return 0;
    }

    public int min() {

        if(!min_stack.empty()){
            return top();
        }
        return 0;

    }




}

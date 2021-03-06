package jzOffer;

import java.util.Stack;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/24
 * @Time:16:47
 * @description:
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 */
public class JZ21 {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,1,2};

        System.out.println(IsPopOrder(a,b));
    }


    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<Integer>();

        int index = 0;

        for(int i = 0;i < pushA.length;i++){
            if(pushA[i] != popA[index]){
                stack.push(pushA[i]);
            }else {
                index++;
            }
        }


        boolean judge = true;

        while(!stack.empty()){
            int last_index = stack.pop();
            if(last_index != popA[index]){
                judge = false;
                break;
            }
            index++;
        }

        return judge;

    }

}

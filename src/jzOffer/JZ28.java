package jzOffer;

import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/20
 * @Time:16:34
 * @description:
 *
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 */
public class JZ28 {


    public static void main(String[] args) {

        int[] a = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {

        Arrays.sort(array);

        int key = array[array.length/2];

        int num = 0;

        int judge = 0;

        for(int i = 0;i < array.length;i++){
            if(array[i] == key){
                num++;
                judge=1;
            }else {
                if(judge == 1){
                    break;
                }
            }
        }


        if(num>array.length/2){
            return key;
        }else {
            return 0;
        }

    }
}

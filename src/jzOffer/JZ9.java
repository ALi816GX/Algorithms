package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/17
 * @Time:23:04
 * @description:
 *
 *
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */


public class JZ9 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }

    public static int JumpFloorII(int target) {


        int result=0;

        if(target==0) {

            result=0;

        }
        else if(target==1) {

            result=1;

        }

        else{

            result = 2 * JumpFloorII(target-1);

        }

        return result;


    }





}

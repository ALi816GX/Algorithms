package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/17
 * @Time:19:23
 * @description:
 *
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 *
 */
public class JZ8 {


    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }

    public static int JumpFloor(int target) {

        if(target <= 3){
            return target;
        }else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }

    }

}

package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/18
 * @Time:18:06
 * @description:
 *
 * 给定一个double类型的浮点数base和int类型的
 * 整数exponent。求base的exponent次方。
 *
 */
public class Twelve {


    public static void main(String[] args) {
        System.out.println(Power(2,-3));

    }

    public static double Power(double base, int exponent) {

        if(exponent > 0) {

            double num = 1.0;

            while (exponent > 0) {
                num *= base;
                --exponent;
            }
            return num;

        }
        else {

            double num = 1.0;

            exponent = - exponent;

            while (exponent > 0) {
                num *= base;
                --exponent;
            }

            return 1.0/num;

        }
    }

}

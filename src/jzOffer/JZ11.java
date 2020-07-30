package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/18
 * @Time:15:39
 * @description:
 */
public class JZ11 {


    public static void main(String[] args) {

        System.out.println();



        System.out.println(NumberOf1(-1));


    }


    public static int NumberOf1(int n) {


        String str = Integer.toBinaryString(n);
        int num = 0;
        int index = str.length()-1;
        while (index >= 0 ){

            if(str.charAt(index) == '1'){
                num++;
            }

            index--;
        }

        return num;
    }



    public static int NumberOf2(int n) {

        if(n>=0){

            int num = n;
            int result = 0;

            while (num != 0) {
                if (num % 2 == 0) {
                    num = num / 2;
                } else {
                    ++result;
                    num = num / 2;
                }
            }

            return result;

        }

        else {

            int num = ~(1)<<1;
            System.out.println(num);

            return NumberOf2(num);

        }
    }



}

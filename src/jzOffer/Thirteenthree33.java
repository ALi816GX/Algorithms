package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/22
 * @Time:03:03
 * @description:
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *
 */


public class Thirteenthree33 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1500));
    }


    public static int GetUglyNumber_Solution(int index) {

        int index_num = 0;
        int i = 1;

        for(i = 1;index_num != index;i++){

            if(IsUglyNumber(i)){
                index_num++;
            }

        }

        return --i;

    }



    public static Boolean IsUglyNumber(int number){

        while(number%2==0){ //推断数是否能被2整除
            number=number/2;
        }

        while(number%3==0){ //推断数是否能被3整除
            number=number/3;
        }

        while(number%5==0){ //推断数是否能被5整除
            number=number/5;
        }

        if(number == 1) {
            return true;
        }
        else {
            return false;
        }
    }


}

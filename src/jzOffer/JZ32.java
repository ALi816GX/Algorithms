package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/21
 * @Time:22:37
 * @description:
 *
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 */
public class JZ32 {

    public static String MinNum = "";

    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        PrintMinNumber(a);
        System.out.println(MinNum);

    }




    public static String PrintMinNumber(int[] numbers) {

        MinNum="";

        for(int i= 0;i < numbers.length;i++) {
            MinNum += numbers[i];
        }

        arrange(numbers,0,numbers.length);

        return MinNum;

    }


    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void arrange(int[] numbers, int st, int len) {
        if (st == len - 1) {
            String num = "";
            for (int i = 0; i < len; i ++) {
                num += numbers[i];
            }
            System.out.println(num);
            if(Long.parseLong(num) < Long.parseLong(MinNum)){
                MinNum = num;
            }
        }

        else {
            for (int i = st; i < len; i ++) {
                swap(numbers, st, i);
                arrange(numbers, st + 1, len);
                swap(numbers, st, i);
            }
        }

    }

}

package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/22
 * @Time:15:28
 * @description:
 *
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 *
 */
public class ThirtyFive35 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0,2,3,2,4,6,6,8,4,64,645,6,456,54,6,345,34};
        System.out.println(InversePairs(a));
    }

    public static int InversePairs(int [] array) {

        int total = 0;

        for(int i = 0;i < array.length;i++){
            for(int j = i+1;j < array.length;j++){
                if(array[i] > array[j]){
                    total++;
                }
            }
        }

        return total%1000000007;
    }





}

package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/18
 * @Time:23:12
 * @description:
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class JZ13 {

    public static void main(String[] args) {
        int[] a ={2,1,3,2,4,3,1,5,4};
        reOrderArray(a);
        for(int i = 0;i < a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void reOrderArray(int [] array) {

        int temp;
        for(int i = 0;i < array.length;i++){
            if(array[i] % 2 == 1){
                for(int j = i;j>=0;j--){
                    if(j-1>=0 && array[j-1]%2==0){
                        temp = array[j-1];
                        array[j-1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

    }

}

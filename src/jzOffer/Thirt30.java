package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/20
 * @Time:21:06
 * @description:
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天JOBDU测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？
 *
 */
public class Thirt30 {

    public static void main(String[] args) {
        int[] a ={1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(a));
    }


    public static int FindGreatestSumOfSubArray(int[] array) {

        int size = array.length;

        int max = array[0];

        for(int i = 0;i < size;i++){

            for(int j = i;j < size;j++){
                int temp = getTotal(array,i,j);
                if(max < temp){
                    max = temp;
                }
            }

        }

        return max;

    }


    public static int getTotal(int[] array,int i,int j){

        int total = 0;

//        System.out.print(" "+i+" "+j+" ");

        for(int k = i;k <= j;k++){
            total += array[k];
        }

//        System.out.println(total);

        return total;
    }


}

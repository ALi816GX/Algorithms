package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/23
 * @Time:16:20
 * @description:
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 */
public class ThirtySeven37 {

    public int GetNumberOfK(int [] array , int k) {
        int total = 0;

        for(int i = 0;i < array.length;i++){
            if(array[i] == k){
                total++;
            }
            if(k < array[i]){
                break;
            }
        }

        return total;
    }

}

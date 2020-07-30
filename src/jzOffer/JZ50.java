package jzOffer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/26
 * @Time:17:15
 * @description:
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 */
public class JZ50 {

    public static void main(String[] args) {
        int[] a = {2,1,3,1,4};
        int[] b = null;
        System.out.println(duplicate(a,a.length,b));
    }


    public static boolean duplicate(int numbers[],int length,int [] duplication) {

        if(length == 0||length==1){
            return false;
        }

        ArrayList<int[]> allRecords = new ArrayList<>();
        for(int i = 0;i < length;i++){
            if(!isExist(allRecords,numbers[i])){
                int[] one = new int[2];
                one[0] = numbers[i]; //字符
                one[1] = 1;             //个数
                allRecords.add(one);       //不存在  则新增
            }
        }


        for(int[] one:allRecords){
            if(one[1] > 1) {
                duplication[0] = one[0];
                return true;
            }
        }


        return false;

    }


    public static Boolean isExist(ArrayList<int[]> records,int num){
        int[] one = null;
        for(int i = 0;i < records.size();i++){
            one = records.get(i);
            if(one[0] == num){
                one[1]++;
                return true;
            }
        }
        return false;
    }



}

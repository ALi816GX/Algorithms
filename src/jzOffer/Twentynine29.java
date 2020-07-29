package jzOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/20
 * @Time:16:05
 * @description:
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字
 * 则最小的4个数字是1,2,3,4,。
 */
public class Twentynine29 {

    public static void main(String[] args) {

        int[] a = {1,2,1,2,3,2,3,2};

        GetLeastNumbers_Solution(a,4);

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


        ArrayList arrayList = new ArrayList();

        if(k>input.length){
            return arrayList;
        }

        Arrays.sort(input);

        for(int i = 0;i < k;i++){
            arrayList.add(input[i]);
            System.out.println(input[i]);
        }

        return arrayList;

    }




}

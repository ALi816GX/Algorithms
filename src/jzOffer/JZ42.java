package jzOffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/25
 * @Time:22:35
 * @description:
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 */
public class JZ42 {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7};
        ArrayList b = FindNumbersWithSum(a,7);
        System.out.println(b.get(0)+" "+b.get(1));

    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();


        for(int i = 0;i < array.length;i++){
            for(int j = i+1;j < array.length;j++){

                int total = array[i] + array[j];
                if(i != j){
                    if(total == sum){
                        ArrayList<Integer> node = new ArrayList<>();
                        node.add(array[i]);
                        node.add(array[j]);
                        arrayList.add(node);
                    }
                }
                if(total > sum){
                    break;
                }
            }
        }

        Comparator c = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)*o1.get(1) > o2.get(0)*o2.get(1)){
                    return 1;
                }else {
                    return -1;
                }

            }
        };

        ArrayList result = null;
        if(arrayList.size() != 0) {
            arrayList.sort(c);
            result = arrayList.get(0);
        }else {

            result = new ArrayList();
        }



        return result;

    }


}

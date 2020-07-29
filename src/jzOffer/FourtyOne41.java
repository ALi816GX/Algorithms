package jzOffer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/25
 * @Time:21:34
 * @description:
 *
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *
 *
 */
public class FourtyOne41 {

    public static void main(String[] args) {
        FindContinuousSequence(100);
    }


    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();


        for(int i = 1;i <= (sum+1)/2;i++){
            for(int j = i+1;j <= (sum+1)/2;j++){

                int total = (i+j)*(j-i+1)/2;
                if(i != j){
                    if(total == sum){
                        arrayList.add(getSequence(i,j));
                    }
                }
                if(total > sum){
                    break;
                }
            }
        }


        return arrayList;

    }


    public static ArrayList<Integer> getSequence(int i,int j){

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int k = i;k <= j;k++){
            arrayList.add(k);
        }

        return arrayList;

    }

}

package jzOffer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/22
 * @Time:15:02
 * @description:
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 */
public class Thirtyfour34 {




    public int FirstNotRepeatingChar(String str) {
        ArrayList<int[]> records = new ArrayList<>();

        for(int i = 0;i < str.length();i++){
            if(!isExist(records,str.charAt(i))){
                int[] one = new int[3];
                one[0] = str.charAt(i); //字符
                one[1] = 1;             //个数
                one[2] = i;             //位置
                records.add(one);       //不存在  则新增
            }
        }

        for(int[] one:records){
            if(one[1] == 1){
                return one[2];
            }
        }

        return -1;
    }


    public static Boolean isExist(ArrayList<int[]> records,int Char){
        int[] one = null;
        for(int i = 0;i < records.size();i++){
            one = records.get(i);
            if(one[0] == Char){
                one[1]++;
                return true;
            }
        }
        return false;
    }


}

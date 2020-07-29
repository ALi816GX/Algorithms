package jzOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/23
 * @Time:18:03
 * @description:
 *
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
public class TwentySeven27 {

    public static void main(String[] args) {



        ArrayList<String> arrayList = Permutation("abc");
        for(String a : arrayList){
            System.out.println(a);
        }


    }


    static TreeSet<String> hashSet = new TreeSet<String>(); //用于排序输出

    public static ArrayList<String> Permutation(String str) {

        hashSet.clear();

        char[] string = new char[str.length()];
        
        for(int i = 0;i < str.length();i++){
            string[i] = str.charAt(i);
        }

        arrange(string,0,string.length);

        ArrayList<String> result = new ArrayList<>();

        result.addAll(hashSet);

        return result;
        
    }


    public static void swap(char[] str, int i, int j) {

            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

    }

    public static void arrange(char[] str, int st, int len) {

        if (st == len - 1) {
            String one = "";
            for (int i = 0; i < len; i ++) {
                one += str[i];
            }


            hashSet.add(one);
        }

        else {
            for (int i = st; i < len; i ++) {
                    swap(str, st, i);
                    arrange(str, st + 1, len);
                    swap(str, st, i);
            }
        }

    }


    

}

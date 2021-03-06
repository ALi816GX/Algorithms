package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/26
 * @Time:17:49
 * @description:
 *
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 */
public class JZ54 {



    //Insert one char from stringstream
    //数组存储每个字符出现的次数
    char [] cn = new char[256];
    StringBuffer sb = new StringBuffer();
    public void Insert(char ch)
    {
        ++cn[ch];
        sb.append(ch+"");
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char [] t = sb.toString().toCharArray();
        for(int i=0;i<t.length;i++){
            if(cn[t[i]]==1){
                return t[i];
            }
        }
        return '#';
    }



}

package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/26
 * @Time:03:14
 * @description:
 *
 *
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 */
public class JZ49 {

    public static void main(String[] args) {
        System.out.println(StrToInt("+000002030300"));
    }


    public static int StrToInt(String str) {

        if(str == null || str.equals("")){
            return 0;
        }

        if(str.length() == 1){
            if(str.charAt(0) == '+'||str.charAt(0) == '-'){
                return 0;
            }
        }

        StringBuffer result = new StringBuffer();

        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if((ch>='0' && ch<='9')||ch == '+'||ch == '-'){
                if((ch == '+'||ch == '-') && i != 0){
                    return 0;
                }else {
                    if(ch != '+'){
                        result.append(ch);
                    }
                }
            }else {
                return 0;
            }

        }


        return Integer.parseInt(result.toString());

    }

}

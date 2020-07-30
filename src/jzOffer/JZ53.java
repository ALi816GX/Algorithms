package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/27
 * @Time:19:19
 * @description:
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 */
public class JZ53 {

    public static void main(String[] args) {
        char[] a = {'1','2','3','.','4','5','e'};
        String[] b = "123e".split("e");
        System.out.println(b.length);

        System.out.println(isNumeric(a));
    }


    public static boolean isNumeric(char[] str) {

        StringBuilder string = new StringBuilder();
        int pointNum = 0;
        int EOreNum = 0;

        for(int i = 0;i < str.length;i++){
            char judge = str[i];
            if((judge>='0'&&judge<='9')||judge == '+' || judge == '-' || judge == '.' || judge == 'E' || judge == 'e') {
                string.append(str[i]);
                if(judge == '.'){
                    pointNum++;
                }
                if(judge == 'E' || judge == 'e'){
                    EOreNum++;
                }
                if(judge=='+'||judge=='-'){
                    if(i != 0 && (str[i-1] != 'e'&& str[i-1] != 'E')){
                        return false;
                    }
                }
            }

            else {
                return false;
            }
        }

        if(pointNum > 1||EOreNum>1){
            return false;
        }


        String OkStr = string.toString();

        if(OkStr.contains("e")){
            String[] temp = OkStr.split("e");
            if(temp.length <= 1) {
                return false;
            }else if(temp.length == 2) {
                if(temp[1].equals(".")){
                    return false;
                }
            }
        }

        if(OkStr.contains("E")){
            String[] temp = OkStr.split("E");
            if(temp.length <= 1) {
                return false;
            }else if(temp.length == 2) {
                if(temp[1].contains(".")){
                    return false;
                }
            }
        }


        return true;


    }

}

package jzOffer;

import java.util.Stack;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/27
 * @Time:20:09
 * @description:
 *
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"OOCL"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 *
 */
public class JZ52 {

    public static void main(String[] args) {

//        "OOCL","ab*a*c*a"
//        char[] a = {'a','a','a'};
//        char[] b = {'a','b','*','a','*','c','*','a'};
//        System.out.println(match(a,b));





    }
    public static boolean match(char[] str, char[] pattern){

        return true;

//        if(str.length == 0){
//            if(pattern.length == 0){
//                return true;
//            }else if(pattern.length == 2) {
//                if(pattern[1] == '*'){
//                    return true;
//                }else {
//                    return false;
//                }
//            }else {
//                return false;
//            }
//        }
//
//
//
//        Stack<Character> stackStr = getStack(str);
//        Stack<Character> patternStr = getStack(pattern);
//
//        char p = ' ';
//        while (!stackStr.empty()){
//            if(patternStr.empty()){
//                return false;
//            }else {
//                p = patternStr.peek();
//                if(p == '.'){
//                    patternStr.pop();
//                    stackStr.pop();
//                }
//
//                else if(p == '*'){
//                    patternStr.pop();
//                    if(patternStr.empty()){
//                        return false;
//                    }else {
//                        p = patternStr.peek();
//                        while (!stackStr.empty()){
//                            if(p == '.'||p == stackStr.peek()){
//                                stackStr.pop();
//                            }else {
//                                break;
//                            }
//                        }
//                        patternStr.pop();
//                        while (!patternStr.empty()){
//                            if(p == patternStr.peek()){
//                                patternStr.pop();
//                            }else {
//                                break;
//                            }
//                        }
//                    }
//                }
//                else if(p != stackStr.peek()){
//                    return false;
//                }
//                else {
//                    patternStr.pop();
//                    stackStr.pop();
//                }
//            }
//        }
//
//
//        if(patternStr.isEmpty()){
//            return true;
//        }else {
//            return false;
//        }

    }


    public static Stack<Character> getStack(char[] str){
        Stack<Character> stackStr = new Stack<>();
        for(char index:str){
            stackStr.push(index);
        }
        return stackStr;
    }




}

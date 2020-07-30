package jzOffer;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class JZ47 {

    public static void main(String[] args) {
        JZ47 jz47 = new JZ47();
        jz47.Sum_Solution(1);
    }

    public int Sum_Solution(int n) {
        int sum = (int) Math.pow(n, 2) + n;
        return sum >> 1;
    }

}

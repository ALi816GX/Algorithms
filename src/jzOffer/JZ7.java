package jzOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class JZ7 {

    public static void main(String[] args) {

        JZ7 jz7 = new JZ7();
        System.out.println(jz7.Fibonacci(39));

    }

    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}

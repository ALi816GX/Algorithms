package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/17
 * @Time:19:11
 * @description:
 */
public class Seven {


    public static void main(String[] args) {
        System.out.println(Fibonacci(39));
    }

    public static int Fibonacci(int n) {

        if(n <= 1){
            return n;
        }else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }

    }



}

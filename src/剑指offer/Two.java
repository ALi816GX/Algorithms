package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/16
 * @Time:15:41
 * @description:
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Two {

    public static void main(String[] args) {

        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));

    }

    public static String replaceSpace(StringBuffer str) {

        String a = str.toString();
        return a.replaceAll(" ","%20");

    }

}

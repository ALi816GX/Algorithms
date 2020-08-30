package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/15
 * @Time:16:20
 * @description:
 */
public class LC92 {

    public static void main(String[] args) {
        LC92 lc92 = new LC92();
        lc92.lengthOfLastWord(" ");
    }

    public int lengthOfLastWord(String s) {

        String temp = s;
        temp = temp.replace(" ", "");
        if (temp.length() == 0) {
            return 0;
        }

        String[] result = s.split(" ");
        return result[result.length - 1].length();

    }

}

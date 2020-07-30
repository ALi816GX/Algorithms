package jzOffer;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class JZ33 {

    public static void main(String[] args) {

        JZ33 jz33 = new JZ33();
        System.out.println(jz33.GetUglyNumber_Solution(900));

    }


    public int GetUglyNumber_Solution(int index) {
        if (index >= 1 && index <= 5) {
            return index;
        } else if (index <= 1000) {
            int count = 5;
            int num = 6;
            for (; num <= index; num++) {
                if (isUgly(num)) {
                    count++;
                }
            }
            num--;
            int needToMoveNum = index - count;
            while (needToMoveNum != 0) {
                num++;
                if (isUgly(num)) {
                    needToMoveNum--;
                }
            }
            return num;
        } else {
            return 500000;
        }
    }

    private boolean isUgly(int num) {
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }

}

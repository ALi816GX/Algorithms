package leetCode;

import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/9
 * @Time:17:43
 * @description:
 */
public class LC119 {

    public static void main(String[] args) {

        LC119 lc119 = new LC119();
        int[] num = new int[]{1, 3, 2};
        lc119.nextPermutation(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(" " + num[i]);
        }
        System.out.println();

    }

    public void nextPermutation(int[] num) {

        if (num.length == 1 || num.length == 0) {
            return;
        }
        int indexLimit = 0;
        int wait_to_swap = 0;
        int tail = num.length - 1;
        // 最后两位升序直接换 即可
        if (num[tail] > num[tail - 1]) {
            int temp = num[tail];
            num[tail] = num[tail - 1];
            num[tail - 1] = temp;
        }
        //从后往前找出最大降序，交换，再排序
        else {
            for (int i = tail; i > 0; i--) {
                if (num[i] > num[i - 1]) {
                    indexLimit = i;
                    wait_to_swap = i - 1;
                    break;
                }
            }
            //完全逆序 -> 下个最大序列 : 返回完全正序
            if (indexLimit == 0) {
                exchange(num, indexLimit);
            }
            // 找出交换完再排序
            else {
                int temp;
                for (int i = tail; i >= indexLimit; i--) {
                    if (num[wait_to_swap] < num[i]) {
                        temp = num[wait_to_swap];
                        num[wait_to_swap] = num[i];
                        num[i] = temp;
                        break;
                    }
                }
                exchange(num, indexLimit);
            }
        }

    }

    public void exchange(int[] num, int index) {
        Arrays.sort(num, index, num.length);
    }

}

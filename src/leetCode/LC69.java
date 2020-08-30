package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/23
 * @Time:13:57
 * @description:
 */
public class LC69 {

    public static void main(String[] args) {
        LC69 lc69 = new LC69();
        int[] B = new int[]{-3, -1, -1, 0, 0, 0, 0, 0, 2};
        int num = lc69.removeDuplicates(B);
        System.out.println(num);
    }

    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int preNum = 0;
        int preNumSize = 0;
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (preNum == A[i] && preNumSize >= 2) {
                indexs.add(i);
            } else {
                if (preNum == A[i]) {
                    preNumSize++;
                } else {
                    preNumSize = 1;
                }
                preNum = A[i];
            }
        }
        int temp = 1;
        for (Integer index : indexs) {
            if (temp == 1) {
                removeByIndex(A, index);
            } else {
                removeByIndex(A, index - temp);
            }
            temp++;
        }
        return A.length - indexs.size();
    }

    public void removeByIndex(int[] A, int index) {
        for (int i = index; i < A.length - 1; i++) {
            A[i] = A[i + 1];
        }
    }


}

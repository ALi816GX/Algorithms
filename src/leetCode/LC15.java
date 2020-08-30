package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/10
 * @Time:22:16
 * @description: 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么
 */
public class LC15 {

    public static void main(String[] args) {
        System.out.println();
    }

    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}

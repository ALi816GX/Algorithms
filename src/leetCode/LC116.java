package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/9
 * @Time:23:14
 * @description: 给出一个有序数组，请在数组中找出目标值的起始位置和结束位置
 * 你的算法的时间复杂度应该在O(log n)之内
 * 如果数组中不存在目标，返回[-1, -1].
 * 例如：
 * 给出的数组是[5, 7, 7, 8, 8, 10]，目标值是8,
 * 返回[3, 4].
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return[-1, -1].
 * <p>
 * For example,
 * Given[5, 7, 7, 8, 8, 10]and target value 8,
 * return[3, 4].
 */
public class LC116 {

    public static void main(String[] args) {
        LC116 lc116 = new LC116();
        System.out.println(lc116.searchRange(new int[]{2, 2}, 2));
    }


    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] searchRange(int[] A, int target) {

        int left = 0;
        int right = A.length - 1;
        int mid = (right + left) / 2;
        int index = -1;

        if (A.length == 1) {
            if (A[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        while (right - left >= 1) {
            if (A[mid] == target) {
                index = mid;
                break;
            } else {
                //right
                if (target > A[mid]) {
                    left = mid;
                }
                //left
                else {
                    right = mid;
                }
                mid = left + right / 2;
            }
        }

        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int _target = A[index];
            int result_left = index;
            int result_right = index;
            for (int i = result_left; result_left >= 0; i--) {
                if (A[i] == _target) {
                    result_left = i;
                }
                break;
            }
            for (int i = result_right; result_left < A.length; i++) {
                
                if (A[i] == _target) {
                    result_left = i;
                }
                break;
            }
            return new int[]{result_left, result_right};
        }
    }


}

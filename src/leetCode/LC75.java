package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/23
 * @Time:17:58
 * @description:
 */
public class LC75 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == target) {
                    return true;
                } else if (matrix[i][0] > target) {
                    break;
                }
            }
        }
        int indexSize = matrix.length;
        int tailNumIndex = matrix[0].length - 1;
        int index = 0;
        for (int i = 0; i < indexSize; i++) {
            if (matrix[i][tailNumIndex] < target) {
                index = i;
                break;
            }
        }
        return findNum(matrix[index], target);
    }

    private boolean findNum(int[] matrix, int target) {
        int head = 0;
        int tail = matrix.length - 1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (target == matrix[mid]) {
                return true;
            } else if (target > matrix[mid]) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return false;
    }

}

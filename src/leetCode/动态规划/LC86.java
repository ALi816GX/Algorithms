package leetCode.动态规划;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/25
 * @Time:00:25
 * @description: 给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，请找出路径上的所有数字之和最小的路径。
 * 注意：你每次只能向下或向右移动。
 *
 * sample
 */
public class LC86 {
    public static void main(String[] args) {
        LC86 lc86 = new LC86();
        int[][] a = new int[][]{{1, 3, 5}, {2, 4, 6}, {3, 2, 1}};
        lc86.minPathSum(a);

    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                }
                if (i != 0 && j == 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                }
                if (i != 0 && j != 0) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}

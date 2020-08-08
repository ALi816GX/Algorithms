package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/9
 * @Time:00:24
 * @description:
 */
public class LC61 {

    public static void main(String[] args) {
        LC61 lc61 = new LC61();
        int[] A = new int[]{0};
        lc61.merge(A, 0, new int[]{-1}, 1);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
        } else {
            int index = 0;
            for (int i = 0; i < n; i++) {

                for (int j = index; j < m; j++) {
                    if (B[i] <= A[j] && j == 0) {
                        index = j;
                        A = exchange(A, B[i], index, m);
                        m++;
                        break;
                    } else if (B[i] >= A[j] && (B[i] <= A[j + 1] || j + 1 == m)) {
                        index = j + 1;
                        A = exchange(A, B[i], index, m);
                        m++;
                        break;
                    }
                }
            }
        }

    }


    public int[] exchange(int A[], int num, int index, int tailIndex) {
        for (int i = tailIndex; i > index; i--) {
            A[i] = A[i - 1];
        }
        A[index] = num;
        return A;
    }

}

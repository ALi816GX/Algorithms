package leetCode;


public class LC147 {

    public static void main(String[] args) {
        LC147 lc147 = new LC147();
        System.out.println(lc147.findMedianSortedArrays(new int[]{1,2,3}, new int[]{3,4,5,5}));
    }

    /**
     * @param A int整型一维数组
     * @param B int整型一维数组
     * @return double浮点型
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length == 0) {
            return singleZeroLength(B);
        }
        if (B.length == 0) {
            return singleZeroLength(A);
        }
        if (A[A.length - 1] <= B[0]) {
            return this.combineToWholeArrays(A, B);
        } else if (B[B.length - 1] <= A[0]) {
            return this.combineToWholeArrays(B, A);
        } else {
            return 2.00;
        }
    }

    public double singleZeroLength(int[] B) {
        if (B.length % 2 == 0) {
            return (B[B.length / 2] + B[B.length / 2 - 1]) / 2.00000;
        }
        return B[B.length / 2];
    }

    public double combineToWholeArrays(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int i = 0;
        for (; i < A.length; i++) {
            result[i] = A[i];
        }
        for (int j = 0; j < B.length; j++) {
            result[i + j] = B[j];
        }
        if (result.length % 2 == 0) {
            return (result[result.length / 2] + result[result.length / 2 - 1]) / 2.00000;
        }
        return result[result.length / 2];
    }
}

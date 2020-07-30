package jzOffer;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class JZ51 {
    public static void main(String[] args) {

        JZ51 jz51 = new JZ51();
        System.out.println(jz51.multiply(new int[]{1, 2, 3, 4, 5}));

    }

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int z = 0; z < B.length; z++) {
            B[z] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }

}

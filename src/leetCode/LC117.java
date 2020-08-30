package leetCode;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/9
 * @Time:22:40
 * @description: 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * 假设数组中不存在重复项。
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */

public class LC117 {

    public int search(int[] A, int target) {
        int result = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                result = i;
            }
            if (A[A.length - 1 - i] == target){
                result =  A.length - 1 - i;
            }
            if(A[i] == target && i == A.length/2){
                result = i;
                break;
            }
        }
        return result;
    }

}

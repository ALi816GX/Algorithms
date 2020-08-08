package leetCode;

import java.util.HashSet;
import java.util.Set;


/**
 * 题目描述
 * 给定一个无序的整数类型数组，求最长的连续元素序列的长度。
 * 例如：
 * 给出的数组为[100, 4, 200, 1, 3, 2],
 * 最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
 * 你需要给出时间复杂度在O（n）之内的算法
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class LC23 {

    public static void main(String[] args) {
        LC23 lc23 = new LC23();
        System.out.println(lc23.longestConsecutive(new int[]{100, 10, 9, 1, 2, 3, 4,101,8,5}));
    }

    /**
     * @param num int整型一维数组
     * @return int整型
     */
    public int longestConsecutive(int[] num) {
        int resultLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        for (int j = 0; j < num.length && set.size() != 0; j++) {
            if (set.contains(num[j])) {
                ResultSet resultSet = calLength(set, num[j]);
                set = resultSet.getSet();
                if (resultSet.getLength() > resultLength) {
                    resultLength = resultSet.getLength();
                }
            }
        }
        return resultLength;
    }

    public ResultSet calLength(Set<Integer> set, int num) {
        int result = 1;
        set.remove(num);
        int _num = num;
        while (set.contains(--num)) {
            result++;
            set.remove(num);
        }
        while (set.contains(++_num)) {
            result++;
            set.remove(_num);
        }
        return new ResultSet(set, result);
    }

    class ResultSet {

        Set<Integer> set;
        int length;

        public ResultSet(Set<Integer> set, int length) {
            this.set = set;
            this.length = length;
        }

        public Set<Integer> getSet() {
            return this.set;
        }

        public int getLength() {
            return this.length;
        }

    }

}

package leetCode;


/**
 * 题目描述
 * 给定一个字符串，找出最长的不具有重复字符的子串的长度。例如，“abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。对于“bbbbb”，最长的不具有重复字符的子串是“b”，长度为1。
 * <p>
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters
 * for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LC146 {

    public static void main(String[] args) {
        LC146 lc146 = new LC146();
        System.out.println(lc146.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxResult = 0;
        int length = s.length();
        int left = 0;
        int right = 1;
        while (true) {
            if (right == length) {
                break;
            }
            int current = getLength(s.substring(left, right));
            if (current > 0) {
                maxResult = current > maxResult ? current : maxResult;
                right++;
            } else {
                left++;
            }
        }
        return maxResult;
    }

    public int getLength(String s) {
        int[] recordNum = new int[150];
        for (int i = 0; i < 150; i++) {
            recordNum[i] = 0;
        }
        int result = s.length();
        for (int j = 0; j < s.length(); j++) {
            recordNum[(int) s.charAt(j)]++;
            if (recordNum[(int) s.charAt(j)] >= 2) {
                result = 0;
                break;
            }
        }
        return result;
    }


}


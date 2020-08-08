package leetCode;


/**
 * 题目描述
 * 找出给出的字符串S中最长的回文子串。假设S的最大长度为1000，并且只存在唯一解。
 * <p>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LC144 {

    public static void main(String[] args) {
        LC144 lc144 = new LC144();
        System.out.println(lc144.longestPalindrome("bbmqbabbbakyhaddaqscdxr"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int j = i + 1;
            while (j < s.length()) {
                if (temp == s.charAt(j)) {
                    String _result = s.substring(i, j + 1);
                    if (isHuiWen(_result) && _result.length() > result.length()) {
                        result = _result;
                    }
                }
                j++;
            }
        }
        return result;

    }

    public boolean isHuiWen(String str) {
        return str.equals(new StringBuffer(str).reverse().toString());
    }

}


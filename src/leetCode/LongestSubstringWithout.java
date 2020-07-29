package leetCode;

import java.util.HashSet;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/19
 * @Time:16:39
 * @description:
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithout {

    public static void main(String[] args) {

        String a = "qopubjguxhxdipfzwswybgfylqvjzhar";
        System.out.println(lengthOfLongestSubstring(a));

    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int max = 0;

        for (int i = 0;i < s.length();i++){

            hashSet.clear();
            for(int j = i;j < s.length();j++){
               if(hashSet.contains(s.charAt(j))){
                   if(hashSet.size()>max){
                       max = hashSet.size();
                   }
                   break;
               }else {
                   hashSet.add(s.charAt(j));
               }

               if(j==s.length()-1){
                   if(hashSet.size()>max){
                       max = hashSet.size();
                   }
                   break;
               }

            }

        }

        return max;

    }

}

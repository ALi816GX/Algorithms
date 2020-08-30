package leetCode.动态规划;

import java.util.*;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/29
 * @Time:15:15
 * @description: 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * 返回的结果为["cats and dog", "cat sand dog"].
 */
public class LC11 {

    public static void main(String[] args) {
        LC11 lc11 = new LC11();
        String s = "aaaaaaaaabbbbbbbbbbbbb";
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("aa");
        set.add("aaa");
        set.add("aaaa");
        set.add("ab");
        set.add("abb");
        set.add("aab");
        set.add("abbb");
        set.add("aaab");
        set.add("aabb");
        set.add("b");
        set.add("bb");
        set.add("bbb");
        set.add("bbbb");
        System.out.println(lc11.wordBreak(s, set).size());

    }


    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        TreeNode root = new TreeNode("", "");
        constructTree(s, dict, root);
        ArrayList<String> result = new ArrayList<>();
        readTree(result, root, s, "");
        return result;
    }

    public void constructTree(String original, Set<String> dict, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.totalStr.length() < original.length()) {
                    for (String word : dict) {
                        String tempTotal = treeNode.totalStr + word;
                        if (tempTotal.length() <= original.length() && original.substring(0, tempTotal.length()).equals(tempTotal)) {
                            TreeNode childNode = new TreeNode(word, tempTotal);
                            queue.offer(childNode);
                            treeNode.putChild(childNode);
                        }
                    }
                }
            }
        }
    }

    public void readTree(ArrayList<String> result, TreeNode root, String original, String temp) {
        if (root.isEmpty() && root.totalStr.equals(original)) {
            result.add(temp);
        } else {
            for (TreeNode child : root.childs) {
                if (temp.isEmpty()) {
                    readTree(result, child, original, child.currentStr);
                } else {
                    readTree(result, child, original, temp + ' ' + child.currentStr);
                }
            }
        }
    }

    static class TreeNode {
        public String currentStr = "";
        public String totalStr = "";
        private List<TreeNode> childs = new ArrayList<>();

        public TreeNode(String current, String totalStr) {
            this.currentStr = current;
            this.totalStr = totalStr;
        }

        public boolean isEmpty() {
            return childs.isEmpty();
        }

        public void putChild(TreeNode treeNode) {
            this.childs.add(treeNode);
        }
    }


}

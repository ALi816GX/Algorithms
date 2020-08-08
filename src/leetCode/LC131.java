package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/8
 * @Time:00:59
 * @description: 题目描述
 * 给出一个仅包含数字的字符串，给出所有可能的字母组合。
 * 数字到字母的映射方式如下:(就像电话上数字和字母的映射一样)
 */
public class LC131 {

    public static void main(String[] args) {
        LC131 lc131 = new LC131();
        System.out.println(lc131.letterCombinations("2343").toString());
    }


    /**
     * @param digits string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> letterCombinations(String digits) {

        Tree root = new Tree();
        List<Tree> resultTreeList = new ArrayList();
        resultTreeList.add(root);
        Map<Character, Character[]> letterMap = new HashMap<>();
        letterMap.put('2', new Character[]{'a', 'b', 'c'});
        letterMap.put('3', new Character[]{'d', 'e', 'f'});
        letterMap.put('4', new Character[]{'g', 'h', 'i'});
        letterMap.put('5', new Character[]{'j', 'k', 'l'});
        letterMap.put('6', new Character[]{'m', 'n', 'o'});
        letterMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        letterMap.put('8', new Character[]{'t', 'u', 'v'});
        letterMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        for (int i = 0; i < digits.length(); i++) {
            resultTreeList = buildTree(resultTreeList, letterMap.get(digits.charAt(i)));
        }
        ArrayList<String> result = new ArrayList<>();
        getRouteValue(result, "", resultTreeList.get(0));
        System.out.println(result.size());
        return result;
    }

    /**
     * index-0: root
     * index-1+: left
     */
    public List<Tree> buildTree(List<Tree> nodeList, Character[] letter) {
        List<Tree> newNodeList = new ArrayList<>();
        newNodeList.add(nodeList.get(0));
        if (nodeList.size() == 1) {
            List<Tree> childs = nodeList.get(0).childs;
            for (int i = 0; i < letter.length; i++) {
                Tree leaf = new Tree(letter[i]);
                childs.add(leaf);
                newNodeList.add(leaf);
            }
        } else {
            for (int i = 1; i < nodeList.size(); i++) {
                Tree node = nodeList.get(i);
                for (int j = 0; j < letter.length; j++) {
                    Tree child = new Tree(letter[j]);
                    node.getChilds().add(child);
                    newNodeList.add(child);
                }
            }
        }
        return newNodeList;
    }

    public void getRouteValue(List<String> result, String str, Tree root) {
        List<Tree> child = root.getChilds();
        if (root.isEmptyChilds()) {
            result.add(str);
        } else {
            for (int i = 0; i < child.size(); i++) {
                Tree left = child.get(i);
                getRouteValue(result, str + left.getValue(), left);
            }
        }
    }

    public class Tree {
        private char value;
        private List<Tree> childs;

        public Tree() {
            childs = new ArrayList();
        }

        public Tree(char data) {
            this.value = data;
            childs = new ArrayList();
        }

        public char getValue() {
            return value;
        }

        public List<Tree> getChilds() {
            return childs;
        }

        public boolean isEmptyChilds() {
            return this.childs.size() == 0;
        }
    }

}

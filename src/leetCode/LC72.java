package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/14
 * @Time:23:11
 * @description:
 */
public class LC72 {

    public static void main(String[] args) {
        LC72 lc72 = new LC72();
        System.out.println(lc72.combine(3, 1));
        System.out.println(lc72.combine(3, 1).size());
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        Tree root = new Tree(-1);
        Queue<Tree> rootQueue = new LinkedList<>();
        Queue<List<Integer>> colsQueue = new LinkedList();
        rootQueue.offer(root);
        colsQueue.offer(new ArrayList<>());
        //建树
        root = buildTree(rootQueue, colsQueue, n, k);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getAllValue(root, result, new ArrayList<>(), k);
        return result;
    }

    public Tree buildTree(Queue<Tree> rootQueue, Queue<List<Integer>> colsQueue, int num, int depth) {
        Tree root = rootQueue.peek();
        while (depth != 0 && !rootQueue.isEmpty()) {
            int nodeLength = rootQueue.size();
            for (int i = 0; i < nodeLength; i++) {
                Tree node = rootQueue.poll();
                List<Integer> col = colsQueue.poll();
                List<Tree> childs = constructChild(col, num);
                node.childs = childs;
                childs.forEach(child -> {
                    rootQueue.offer(child);
                    List<Integer> tempCols = new ArrayList<>(col);
                    tempCols.add(child.value);
                    colsQueue.offer(tempCols);
                });
            }
            --depth;
        }
        return root;
    }

    private List<Tree> constructChild(List<Integer> tempCol, int num) {
        List<Integer> newCol = new ArrayList<>(tempCol);
        List<Tree> treeList = new ArrayList<>();
        int tailNum = 1;
        if (!tempCol.isEmpty()) {
            tailNum = newCol.get(tempCol.size() - 1) + 1;
        }
        for (int i = tailNum; i <= num; i++) {
            newCol.add(i);
            treeList.add(new Tree(i));
        }
        return treeList;
    }

    private void getAllValue(Tree root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> route, int depth) {
        List<Tree> childs = root.childs;
        if (root.isEmptyChilds() && depth == 0) {
            result.add(route);
        } else {
            --depth;
            for (Tree child : childs) {
                ArrayList<Integer> arrayList = new ArrayList(route);
                arrayList.add(child.value);
                getAllValue(child, result, arrayList, depth);
            }
        }
    }

    public static class Tree {
        int value;
        List<Tree> childs;

        Tree(int data) {
            this.value = data;
            childs = new ArrayList();
        }

        boolean isEmptyChilds() {
            return this.childs == null || this.childs.size() == 0;
        }
    }


}

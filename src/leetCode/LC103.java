package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LC103 {

    public static void main(String[] args) {
        LC103 lc103 = new LC103();
        lc103.permuteUnique(new int[]{1, 1, 2});
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<Integer> numList = new ArrayList<>();
        for (int temp : num) {
            numList.add(temp);
        }

        Tree root = new Tree(-1);
        Queue<Tree> resultTreeList = new LinkedList<>();
        Queue<List<Integer>> queueCols = new LinkedList();
        resultTreeList.offer(root);
        queueCols.offer(new ArrayList<>());
        //建树
        root = buildTree(resultTreeList, numList, queueCols);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getAllValue(root, result, new ArrayList<>());
        //遍历
//        for (ArrayList<Integer> a : result) {
//            System.out.println(a);
//        }
        return result;
    }

    public Tree buildTree(Queue<Tree> treeQueue, List<Integer> original, Queue<List<Integer>> queueCols) {
        Tree root = treeQueue.peek();
        int depth = original.size();
        while (depth != 0 && !treeQueue.isEmpty()) {
            int nodeLength = treeQueue.size();
            for (int i = 0; i < nodeLength; i++) {
                Tree node = treeQueue.poll();
                List<Integer> col = queueCols.poll();
                List<Tree> childs = constructChild(original, col);
                node.childs = childs;
                childs.forEach(child -> {
                    treeQueue.offer(child);
                    List<Integer> tempCols = new ArrayList<>(col);
                    tempCols.add(child.value);
                    queueCols.offer(tempCols);
                });
            }
            --depth;
        }
        return root;
    }

    private List<Tree> constructChild(List<Integer> original, List<Integer> tempCol) {
        List<Integer> originalList = new ArrayList<>(original);
        for (Integer integer : tempCol) {
            int index = originalList.indexOf(integer);
            originalList.remove(index);
        }
        List<Integer> noRepeat = originalList.stream().distinct().collect(Collectors.toList());
        List<Tree> list = new ArrayList<>();
        noRepeat.forEach(temp -> {
            list.add(new Tree(temp));
        });
        return list;
    }

    private void getAllValue(Tree root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> route) {
        List<Tree> childs = root.childs;
        if (childs.size() == 0) {
            result.add(route);
        } else {
            for (Tree child : childs) {
                ArrayList<Integer> arrayList = new ArrayList(route);
                arrayList.add(child.value);
                getAllValue(child, result, arrayList);
            }
        }
    }

    public class Tree {
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

package leetCode.动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/26
 * @Time:00:09
 * @description: 题目描述
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
 * 例如，给出的三角形如下：
 * [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
 * 注意：
 * 如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。
 */
public class LC31 {

    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(3);
        arrayList2.add(4);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(6);
        arrayList3.add(5);
        arrayList3.add(7);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(4);
        arrayList4.add(1);
        arrayList4.add(8);
        arrayList4.add(3);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(arrayList1);
        arrayList5.add(arrayList2);
        arrayList5.add(arrayList3);
        arrayList5.add(arrayList4);
        LC31 lc31 = new LC31();
        System.out.println(lc31.minimumTotal(arrayList5));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currentTriangle = triangle.get(i);
            List<Integer> currentMinResult = new ArrayList<>();
            for (int j = 0; j < currentTriangle.size(); j++) {
                List<Integer> preMinResult = result.get(i - 1);
                if (j == 0) {
                    currentMinResult.add(preMinResult.get(0) + currentTriangle.get(0));
                } else if (j == currentTriangle.size() - 1) {
                    currentMinResult.add(preMinResult.get(j - 1) + currentTriangle.get(j));
                } else {
                    currentMinResult.add(Math.min
                            (preMinResult.get(j - 1) + currentTriangle.get(j), preMinResult.get(j) + currentTriangle.get(j))
                    );
                }
            }
            result.add(currentMinResult);
        }

        return Collections.min(result.get(triangle.size() - 1));

    }

}

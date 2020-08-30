package leetCode;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/23
 * @Time:19:36
 * @description: 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class LC3 {

    public static void main(String[] args) {
        LC3 lc3 = new LC3();
        Point[] result = new Point[13];
        result[0] = new Point(0, 9);
        result[1] = new Point(138, 429);
        result[2] = new Point(115, 359);
        result[3] = new Point(115, 359);
        result[4] = new Point(-30, -102);
        result[5] = new Point(230, 709);
        result[6] = new Point(-161, -481);
        result[7] = new Point(207, 639);
        result[8] = new Point(23, 79);
        result[9] = new Point(-230, -691);
        result[10] = new Point(-115, -341);
        result[11] = new Point(92, 289);
        result[12] = new Point(-184, -551);
        System.out.println(lc3.maxPoints(result));
    }

    /**
     * @param points Point类一维数组
     * @return int整型
     */
    public int maxPoints(Point[] points) {
        if (points.length == 1) {
            return 1;
        }
        Map<String, PointCombination> result = new HashMap<>();
        for (int x = 0; x < points.length; x++) {
            for (int y = x + 1; y < points.length; y++) {
                String key = getValue(points[x], points[y]);
                if (result.containsKey(key)) {
                    result.get(key).set.add(x);
                    result.get(key).set.add(y);
                } else {
                    List input = new ArrayList<>();
                    input.add(x);
                    input.add(y);
                    PointCombination pointCombination = new PointCombination(input);
                    result.put(key, pointCombination);
                }
            }
        }
        int max = 0;
        for (PointCombination pointCombination : result.values()) {
            int temp = pointCombination.set.size();
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    private String getValue(Point point1, Point point2) {
        if (point2.x - point1.x == 0) {
            return "x=" + point1.x;
        } else {
            double k = (point2.y - point1.y) * 1.000000 / (point2.x - point1.x);
            double b = point1.y - ((point2.y - point1.y) * point1.x / (point2.x - point1.x));
            DecimalFormat df = new DecimalFormat("#.000000");
            String _k = df.format(k);
            String _b = df.format(b);
            return _k + _b;
        }
    }

    public static class PointCombination {
        Set<Integer> set = new HashSet<>();

        PointCombination(List<Integer> list) {
            set.addAll(list);
        }
    }

    public static class Point {
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

}

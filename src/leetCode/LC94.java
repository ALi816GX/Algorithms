package leetCode;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/11
 * @Time:00:13
 * @description:
 */
public class LC94 {

    public static void main(String[] args) {
        LC94 lc94 = new LC94();
        ArrayList<Interval> arrayList = new ArrayList<>();
        arrayList.add(new Interval(1, 3));
        arrayList.add(new Interval(2, 6));
        arrayList.add(new Interval(8, 10));
        arrayList.add(new Interval(15, 18));
        ArrayList<Interval> result = lc94.merge(arrayList);
        result.forEach(interval -> System.out.println(interval.toString()));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i+1; j < intervals.size(); j++) {
                Interval i1 = intervals.get(i);
                Interval i2 = intervals.get(j);
                Interval combineBoth = combine(i1, i2);
                if (combineBoth != null) {
                    intervals.remove(i1);
                    intervals.remove(i2);
                    intervals.add(combineBoth);
                    merge(intervals);
                    break;
                }
            }
        }
        return intervals;
    }

    public Interval combine(Interval i1, Interval i2) {
        if (i1.start > i2.end || i1.end < i2.start) {
            return null;
        } else {
            return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}

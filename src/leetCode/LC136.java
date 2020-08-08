package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2020/8/1
 * @Time:23:20
 * @description: 请将给出的罗马数字转化为整数
 * 保证输入的数字范围在1 到 3999之间。
 * <p>
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class LC136 {

    public static void main(String[] args) {
        LC136 lc136 = new LC136();
        System.out.println(lc136.romanToInt("MCMXCVI"));
    }

    int romanToInt(String s) {
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        s = new StringBuffer(s).reverse().toString();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += map.get("" + s.charAt(i));
        }
        return result;
    }


}

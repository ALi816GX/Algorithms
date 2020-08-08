package leetCode;

/**
 * 题目描述
 * 给出两个用字符串表示的二进制数，返回他们的和（也用字符串表示）
 * 例如：
 * a ="11"
 * b ="1"
 * 返回"100".
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a ="11"
 * b ="1"
 * Return"100".
 */
public class LC84 {

    public static void main(String[] args) {
        LC84 lc84 = new LC84();
        System.out.println(lc84.addBinary("111", "1"));
    }

    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            b = constructStr(a.length() - b.length(), b);
        } else if (a.length() < b.length()) {
            a = constructStr(b.length() - a.length(), a);
        }
        return caculate(new StringBuffer(a).reverse().toString(), new StringBuffer(b).reverse().toString());
    }

    public String constructStr(int distance, String str) {
        for (int i = 0; i < distance; i++) {
            str = '0' + str;
        }
        return str;
    }

    public String caculate(String a, String b) {
        int size = a.length();
        char temp = 0;
        String result = "";
        for (int i = 0; i < size; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                if (temp == 0 && a.charAt(i) == '0') {
                    result += '0';
                    temp = 0;
                } else if (temp == 0 && a.charAt(i) == '1') {
                    result += '0';
                    temp = 1;
                } else if (temp == 1 && a.charAt(i) == '0') {
                    result += '1';
                    temp = 0;
                } else {
                    result += '1';
                    temp = 1;
                }
            } else {
                if (temp == 0) {
                    result += '1';
                    temp = 0;
                } else {
                    result += '0';
                    temp = 1;
                }
            }
        }
        if (temp == 1) {
            result += '1';
        }
        return new StringBuffer(result).reverse().toString();
    }

}


//##case 2:
//    public String addBinary(String a, String b) {
//        int result = getIntByStrBinary(a) + getIntByStrBinary(b);
//        if (result == 0) {
//            return "0";
//        }
//        return getStringByInt(result);
//    }
//
//    public int getIntByStrBinary(String str) {
//        int result = 0;
//        for (int i = str.length() - 1; i >= 0; i--) {
//            int index = str.length() - i - 1;
//            result += Math.pow(2, index) * Integer.parseInt(String.valueOf(str.charAt(i)));
//        }
//        return result;
//    }
//
//    public String getStringByInt(int number) {
//        String result = "";
//        while (number != 0) {
//            result += number % 2;
//            number = number / 2;
//        }
//        return new StringBuffer(result).reverse().toString();
//    }

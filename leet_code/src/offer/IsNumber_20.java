package offer;

/**
 * @author jianglei
 * @date 2020/2/28 0:00
 * <p>
 * 题号：面试题20. 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 注意：
 * 本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 */
public class IsNumber_20 {
    private static boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return false;
        }
        int i=0;

        if(s.charAt(i)=='+'||s.charAt(i)=='-'){
            i++;
        }
        if(i==s.length()) {
            return false;
        }

        int pointNum = 0;
        int digitalNum = 0;

        while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9' || s.charAt(i)=='.')){
            if(s.charAt(i)=='.'){
                pointNum++;
            }else{
                digitalNum++;
            }
            i++;
        }
        if(pointNum > 1 || digitalNum < 1) {
            return false;
        }
        if(i == s.length()) {
            return true;
        }

        if(s.charAt(i)=='e'){
            i++;
            if(i == s.length()) {
                return false;
            }
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                i++;
                if(i == s.length()) {
                    return false;
                }
            }
            while(i<s.length()&&(s.charAt(i)>='0' && s.charAt(i)<='9')){
                i++;
            }
            if(i == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "+100";
        boolean number1 = isNumber(s1);
        System.out.println(number1);

        String s2 = "1a3.14";
        boolean number2 = isNumber(s2);
        System.out.println(number2);
    }
}

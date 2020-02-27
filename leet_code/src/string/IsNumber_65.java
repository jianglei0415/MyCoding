package string;

/**
 * @author jianglei
 * @date 2020/2/28 0:04
 * <p>
 * 题号：#65 有效数字
 * <p>
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 
 * 我们有意将问题陈述地比较模糊。
 * 在实现代码之前，
 * 你应当事先思考所有可能的情况。
 * 这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 */
public class IsNumber_65 {
    private static boolean isNumber(String s) {
        int state = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                case '-':
                    if (state == 0) {
                        state = 1;
                    } else if (state == 4) {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    switch (state) {
                        case 0:
                        case 1:
                        case 2:
                            state = 2;
                            break;
                        case 3:
                            state = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            state = 5;
                            break;
                        case 7:
                            state = 8;
                            break;
                        case 8:
                            state = 8;
                            break;
                        default:
                            return false;
                    }
                    break;
                case '.':
                    switch (state) {
                        case 0:
                        case 1:
                            state = 7;
                            break;
                        case 2:
                            state = 3;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 'e':
                    switch (state) {
                        case 2:
                        case 3:
                        case 8:
                            state = 4;
                            break;
                        default:
                            return false;
                    }
                    break;
                default:
                    return false;

            }
        }
        return state == 2 || state == 3 || state == 5 || state == 8;
    }

    private static boolean isNumber1(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (; chars[i] == ' '; i++) {
        }
        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }

        int n_nm, n_pt;
        for (n_nm = 0, n_pt = 0; (chars[i] <= '9' && chars[i] >= '0') || chars[i] == '.'; i++) {
            if (chars[i] == '.') {
                n_pt++;
            } else {
                n_nm++;
            }
        }
        if (n_pt > 1 || n_nm < 1) {
            return false;
        }
        if (chars[i] == 'e') {
            i++;
            if (chars[i] == '+' || chars[i] == '-') {
                i++;
            }

            int n_nm_1 = 0;
            for (; chars[i] >= '0' && chars[i] <= '9'; i++, n_nm_1++) {
            }
            if (n_nm_1 < 1) {
                return false;
            }
        }

        for (; chars[i] == ' '; i++) {
        }

        return chars[i] == 0;
    }

    public static void main(String[] args) {
        String s1 = "0";
        boolean number1 = isNumber(s1);
        System.out.println(number1);

        String s2 = " 0.1";
        boolean number2 = isNumber(s2);
        System.out.println(number2);

        String s3 = "abc";
        boolean number3 = isNumber(s3);
        System.out.println(number3);

        String s4 = "1 a";
        boolean number4 = isNumber(s4);
        System.out.println(number4);

        String s5 = "";
        boolean number5 = isNumber(s5);
        System.out.println(number5);

        String s6 = "2e10";
        boolean number6 = isNumber(s6);
        System.out.println(number6);

        String s7 = " -90e3   ";
        boolean number7 = isNumber(s7);
        System.out.println(number7);

        String s8 = " 1e";
        boolean number8 = isNumber(s8);
        System.out.println(number8);

        String s9 = "e3";
        boolean number9 = isNumber(s9);
        System.out.println(number9);

        String s10 = " 6e-1";
        boolean number10 = isNumber(s10);
        System.out.println(number10);

        String s11 = " 99e2.5 ";
        boolean number11 = isNumber(s11);
        System.out.println(number11);

        String s12 = "53.5e93";
        boolean number12 = isNumber(s12);
        System.out.println(number12);

        String s13 = " --6 ";
        boolean number13 = isNumber(s13);
        System.out.println(number13);

        String s14 = "-+3";
        boolean number14 = isNumber(s14);
        System.out.println(number14);

        String s15 = "95a54e53";
        boolean number15 = isNumber(s15);
        System.out.println(number15);
    }
}

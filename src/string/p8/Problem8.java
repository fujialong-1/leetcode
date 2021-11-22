package string.p8;

public class Problem8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi(""));
    }
    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        //1.去空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        //2.排除极端情况 "    "
        if (index == len) {
            return 0;
        }
        //3.设置符号
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar == '-') {
            index++;
            sign = -1;
        } else if (firstChar == '+') {
            index++;
        }
        //last 记录上一次的res，以此来判断是否溢出
        int res = 0, last = 0;
        while (index < len) {
            char c = chars[index];
            if (c < '0' || c > '9') {
                break;
            }
            int tem = c - '0';
            last = res;
            res = res * 10 + tem;
            //如果不相等就是溢出了
            if (last != res / 10) {
                return (sign == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        return res * sign;
    }
}

package string.p5;

public class Problem5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = " ";
//        char c = ' ';
//        System.out.println(s.equals(String.valueOf(c)));
        StringBuffer str = new StringBuffer("We are happy.");
        System.out.println(solution.replaceSpace(str));
    }
}
//替换空格
class Solution {
    //使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        //选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < str.length(); i++) {
            //str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            if (" ".equals(String.valueOf(str.charAt(i)))){
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

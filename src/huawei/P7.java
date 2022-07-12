package huawei;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: Jialong Fu
 * @Date: 2022/7/11 9:59
 */
public class P7 {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("4");
        strings.add("3");
        strings.add("2");
        strings.add("1");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    // 待实现函数，在此函数中填入答题代码
    private static int getNormalDeviceNum(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            String temp = String.valueOf(i);
            if (!(temp.contains("4") || temp.contains("18"))) {
                count++;
            }
        }
        return count;
    }

}

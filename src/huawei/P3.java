package huawei;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/26 10:59
 */
public class P3 {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        int nValue = cin.nextInt();
//        int mValue = cin.nextInt();
//        cin.nextLine();
//        String[] strings = new String[mValue];
//        for (int i = 0; i < mValue; i++) {
//            strings[i] = cin.nextLine();
//        }
//        cin.close();

//        System.out.println((char)(47));

        int nValue = 2;
        String[] strings = new String[]{
                "aabbccFFFFx2x2",
                "aaccddFFFFx2x2",
                "aabcdFFFFx2x2"
        };

        char[] results = getNTimesCharacter(nValue, strings);

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                System.out.print(results[i]);
            } else {
                System.out.print(" " + results[i]);
            }
        }
        System.out.print("]");
    }

    // 待实现函数，在此函数中填入答题代码
    private static char[] getNTimesCharacter(int nValue, String[] strings) {
        // 遍历每一个字符串，记录下在这个字符串中每个字符出现的次数
        // 构造一个int数组，保存每个字符在字符串中出现的最小次数，再将最小次数与n值比较，>=n的保存到结果中
        int[] count = new int[128];
        for (int i = 0; i < 128; i++) {
            count[i] = Integer.MAX_VALUE;
        }
        for (String words: strings) {
            int[] temp = new int[128];
            char[] chars = words.toCharArray();
            for (char c: chars) {
                temp[c]++;
            }
            for (int i = 0; i < 128; i++) {
                count[i] = count[i] <= temp[i] ? count[i] : temp[i];
            }
        }
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (count[i] >= nValue) {
                result.add((char)i);
            }
        }
        char[] resultChar = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultChar[i] = result.get(i);
        }
        return resultChar;
    }
}

package huawei;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: Jialong Fu
 * @Date: 2022/6/7 20:10
 */
public class P9 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int recordNum = Integer.valueOf(cin.nextLine());
        List<String> records = new ArrayList<>(recordNum);
        for (int i = 0; i < recordNum; i++) {
            records.add(cin.nextLine());
        }
        cin.close();
        String[][] results = getPhoneRecord(records);
        for (String[] result : results) {
            System.out.println(String.join(" ", Arrays.asList(result)));
        }
    }

    private static String[][] getPhoneRecord(List<String> records) {
        // 在此补充你的代码
        // 记录每一个号码的接通和拒接次数
        // 如果号码在白名单中，接通
        // 不在白名单中，拒接
        // 关键问题在于如何判断一个号码在不在白名单中
        // 对于号码后面没有*号的，通过hashSet直接判断
        // 对于有*号的，利用字符串匹配原则判断
        // 还得准备一个电话白名单
        // 用来存放结果，一个号码对应一个数组，数组记录接通和拒绝的次数
        // 拒绝的次数等于C的次数减去W的次数

        // 号码白名单，用来记录完整的号码
        HashSet<String> passNumber = new HashSet<>();
        // 号码白名单，用来记录带有通配符的号码
        List<String> passNumberWithWildcard = new LinkedList<>();

        for (String item : records) {
            String[] strings = item.split(" ");
            // TODO
            if ("C".equals(strings[0])) {
                if (passNumber.contains(strings[1])) {

                }
            } else if ("W".equals(strings[0])) {

            }
        }

        // 这个用来记录什么，每一个号码对应什么，对应一个数组，这个数组应该包含什么，包含一个出现次序编号，接通次数和拒接次数
        Map<String, int[]> result = new HashMap<>();

        return new String[0][0];
    }
}

package huawei;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: Jialong Fu
 * @Date: 2022/6/7 20:10
 */
public class P9 {

    public static void main(String[] args) {

        List<String> records = new LinkedList<>();
        records.add("C 13300000000");
        records.add("W 13144444444");
        records.add("C 13144444444");
        records.add("C 03712832444");
        records.add("C 03712832233");
        records.add("W 03712832*");
        records.add("C 03712832444");
        String[][] results = getPhoneRecord(records);
        for (String[] result : results) {
            System.out.println(String.join(" ", Arrays.asList(result)));
        }

//        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        int recordNum = Integer.valueOf(cin.nextLine());
//        List<String> records = new ArrayList<>(recordNum);
//        for (int i = 0; i < recordNum; i++) {
//            records.add(cin.nextLine());
//        }
//        cin.close();
//        String[][] results = getPhoneRecord(records);
//        for (String[] result : results) {
//            System.out.println(String.join(" ", Arrays.asList(result)));
//        }
    }

    private static String[][] getPhoneRecord(List<String> records) {

        // 保存结果
        // String对应号码，int[]对应接通次数和拒接次数
        Map<String, Integer[]> result = new HashMap<>();

        // 用来记录号码出现的顺序
        List<String> phone = new ArrayList<>();

        // 号码白名单，用来记录完整的号码
        Set<String> passNumber = new HashSet<>();
        // 通配符号码白名单，用来记录带有通配符的号码
        List<String> passNumberWithWildcard = new LinkedList<>();

        for (String item : records) {

            String[] strings = item.split(" ");

            // 如果呼入代码为C
            if ("C".equals(strings[0])) {
                if (!phone.contains(strings[1])) {
                    phone.add(strings[1]);
                }

                // 如果号码在号码白名单中，接通
                if (passNumber.contains(strings[1])) {

                    if (result.containsKey(strings[1])) {
                        Integer[] ints = result.get(strings[1]);
                        ints[0]++;
                        result.put(strings[1], ints);
                    } else {
                        result.put(strings[1], new Integer[]{1, 0});
                    }
                }
                // 如果号码不在号码白名单中
                else {
                    boolean flag = false;
                    for (String string : passNumberWithWildcard) {
                        String num = string.substring(0, string.length() - 1);
                        if (strings[1].contains(num) && strings[1].indexOf(num) == 0) {
                            flag = true;
                            break;
                        }
                    }
                    // 如果号码在通配符号码白名单中，接通
                    if (flag) {
                        if (result.containsKey(strings[1])) {
                            Integer[] ints = result.get(strings[1]);
                            ints[0]++;
                            result.put(strings[1], ints);
                        } else {
                            result.put(strings[1], new Integer[]{1, 0});
                        }
                    }
                    // 不在，拒接
                    else {
                        if (result.containsKey(strings[1])) {
                            Integer[] ints = result.get(strings[1]);
                            ints[1]++;
                            result.put(strings[1], ints);
                        } else {
                            result.put(strings[1], new Integer[]{0, 1});
                        }
                    }
                }
            } else if ("W".equals(strings[0])) {
                if (strings[1].endsWith("*")) {
                    passNumberWithWildcard.add(strings[1]);
                } else {
                    passNumber.add(strings[1]);
                }
            }
        }
        int size = result.size();
        String[][] newResult = new String[size][3];
        for (int i = 0; i < size; i++) {
            String key = phone.get(i);
            Integer[] ints = result.get(key);
            newResult[i][0] = key;
            newResult[i][1] = String.valueOf(ints[0]);
            newResult[i][2] = String.valueOf(ints[1]);
        }
        return newResult;
    }
}

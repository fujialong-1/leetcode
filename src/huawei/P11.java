package huawei;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Jialong Fu
 * @Date: 2022/7/12 16:33
 */
public class P11 {
    static class DataFragment {
        int dataType;
        int index;
        int endFlag;
        int len;
        String data;

        DataFragment(int dataType, int index, int endFlag, int len, String data) {
            this.dataType = dataType;
            this.index = index;
            this.endFlag = endFlag;
            this.len = len;
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int dataFragmentCnt = cin.nextInt();
        DataFragment[] dataFragments = new DataFragment[dataFragmentCnt];
        for (int i = 0; i < dataFragmentCnt; i++) {
            int dataType = cin.nextInt();
            int index = cin.nextInt();
            int endFlag = cin.nextInt();
            int len = cin.nextInt();
            String data = cin.next();
            dataFragments[i] = new DataFragment(dataType, index, endFlag, len, data);
        }
        int dstType = cin.nextInt();
        cin.close();

        System.out.println(recombine(dataFragments, dstType));

    }

    static String recombine(DataFragment[] dataFragments, int dstType) {

        // 1、从里面选出数据类型一致的数据分段保存到List中
        List<DataFragment> dataList = new LinkedList<>();
        for (DataFragment dataFragment : dataFragments) {
            if (dataFragment.dataType == dstType) {
                dataList.add(dataFragment);
            }
        }
        if (dataList.size() == 0) {
            return "NA";
        }
        // 2、对数据片段按分段序号进行排序
        Collections.sort(dataList, (DataFragment d1, DataFragment d2) -> d1.index - d2.index);
        // 3、对分组序号相同的去重
        List<DataFragment> newDataList = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).index == num) {
                newDataList.add(dataList.get(i));
                num++;
            } else if (dataList.get(i).index != num - 1) {
                return "NA";
            }
        }
        if (newDataList.get(num - 1).endFlag != 1 || num != (newDataList.get(num - 1).index + 1)) {
            return "NA";
        }
        StringBuilder result = new StringBuilder();
        for (DataFragment dataFragment : newDataList) {
            result.append(dataFragment.data);
        }
        return result.toString();
    }
}

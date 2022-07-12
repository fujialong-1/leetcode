package huawei;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: Jialong Fu
 * @Date: 2022/7/11 15:53
 */
public class P19 {
    static class AllocatedMemory {

        AllocatedMemory() {

        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {
            // 在此补充你的代码
            return "";
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            // 在此补充你的代码
            return false;
        }
    }

    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }
}

package scale.p1009;

import java.util.*;

public class Problem1009 {

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();

        List<int[]> list = new ArrayList<>();
        int[] a = {0, 2};
        System.out.println(a[0]);
        list.add(a);
        System.out.println(list.get(0)[1]);
        System.out.println(Arrays.toString(list.get(0)));



        /*int n = 5;
        int[] bits = new int[32];
        for(int i = 31; i >= 0; i--) {
            bits[i] = n & 0x1;
            n = n >>> 1;
        }
        System.out.println(Arrays.toString(bits));
        int index = 0;
        for(; index < 32; index++) {
            if(bits[index] != 0) break;
        }
        System.out.println(index);*/
        System.out.println(bitwiseComplement(5));

    }

    // 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
    public static int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int[] bits = new int[32];
        for(int i = 31; i >= 0; i--) {
            bits[i] = n & 0x1;
            n = n >>> 1;
        }
        int index = 0;
        for(; index < 32; index++) {
            if(bits[index] != 0) break;
        }
        int res = 0;
        for(int i = 31; i >= index; i--){
            if(bits[i] == 0) {
                res = res + (int) Math.pow(2, 31-i);
            }
        }
        return res;
    }
}

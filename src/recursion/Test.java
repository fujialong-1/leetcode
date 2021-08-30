package recursion;

// 递归函数的学习
/**
 * 递归的三大要素
 * 第一要素：明确你这个函数想要干什么，确定递归变量
 * 第二要素：寻找递归结束条件
 * 第三要素：找出函数的等价关系式
 * 想清楚当递归变量退化到基本量时，应该进行什么样的操作
 */

public class Test {

    // 斐波那契数列
    // n是变量
    public static int f(int n) {
        if (n < 0) {
            System.out.println("请输入正整数！");
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f(n-1) + f(n-2);
    }

    // 小青蛙跳台阶
    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int f1(int n) {
        if (n <= 0) {
            System.out.println("请输入正实数");
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n-1) + f(n-2);
    }





    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(f1(i));
        }
    }


}

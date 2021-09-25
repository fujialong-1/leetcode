package array.p4;

public class Problem4 {

    public static void main(String[] args) {

    }

    // 寻找两个正序数组的中位数
    // 思路：
    // 1、3指针法
    // 指针1遍历nums1，指针2遍历nums2,指针3记录当前是第几个数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        int i = 0;
        int j = 0;
        int k = 0;
        if (sum % 2 == 1) {
            int target = (sum + 1) / 2;
            // 和为奇数
            while (i < l1 && j < l2) {
                k++;
                if (nums1[i] >= nums2[j]) {
                    if (k == target) return (double) nums2[j];
                    j++;
                } else {
                    if (k == target) return (double) nums1[i];
                    i++;
                }
            }
            while (i < l1) {
                k++;
                if (k == target) return (double) nums1[i];
                i++;
            }
            while (j < l2) {
                k++;
                if (k == target) return (double) nums2[j];
                j++;
            }
        } else {
            int target = sum / 2;
            // 和为偶数
            double res = 0.0;
            while (i < l1 && j < l2) {
                k++;
                if (nums1[i] >= nums2[j]) {
                    if (k == target) res = (double) nums2[j];
                    if (k == target + 1) return (res+nums2[j])/2;
                    j++;
                } else {
                    if (k == target) res = (double) nums1[i];
                    if (k == target + 1) return (res+nums1[i])/2;
                    i++;
                }
            }
            while (i < l1) {
                k++;
                if (k == target) res = (double) nums1[i];
                if (k == target + 1) return (res+nums1[i])/2;
                i++;
            }
            while (j < l2) {
                k++;
                if (k == target) res = (double) nums2[j];
                if (k == target + 1) return (res+nums2[j])/2;
                j++;
            }
        }
        return 0.0;
    }

}

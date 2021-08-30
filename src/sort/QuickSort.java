package sort;

//思想:   1.在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
//
//       2.将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
//
//       3.对左右两个分区重复以上步骤直到所有元素都是有序的。


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) return;// 这一步很重要
        int i, j, temp;
        i = low;
        j = high;
        temp = arr[low];

        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) swap(arr, i, j);
        }

        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);












        /*int i, j, temp;
        if (low > high) return;
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (arr[j] > temp && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) swap(arr, i, j);
        }
        //最后将基准位与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);*/
    }

    public static void swap(int[] a, int i, int j) {
        /*int temp = a[i];
        a[i] = a[j];
        a[j] = temp;*/


        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

import java.util.Arrays;

public class QuickSort {



    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 4, 9};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr.length > 1) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        //base case
        if (left > right)
            return;
        //定义基准值为数组第一个数
        int pivot = a[left];
        int i = left;
        int j = right;

        while (i < j) {
            //从右往左寻找全部比pivot小的数
            while (a[j] >= pivot && i < j) {
                j--;
            }
            //从左往右寻找全部比pivot大的数
            while (a[i] <= pivot && i < j) {
                i++;
            }
            //如果 i<j，则swap
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //i,j相遇，将pivot和指针重合点交换，即：pivot左边都是比pivot小的数，pivot右边都是比pivot大的数
        a[left] = a[i];
        a[i] = pivot;
        //对左边的子数组进行快速排序
        quickSort(a, left, i - 1);
        //对右边的子数组进行快速排序
        quickSort(a, i + 1, right);
    }
}

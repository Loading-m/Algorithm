import java.util.Arrays;

public class MergeSort3 {
    public static void main(String[] args) {
        int[] arr = {7, 2, 8, 3, 4, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i, j, k;
        // 将需要排序的序列copy至临时数组
        for (k = left; k <= right; k++) {
            temp[k] = arr[k];
        }
        // i,j分别指向两个序列的起始位置
        for (i = left, j = mid + 1, k = i; i <= mid && j <= right; k++) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i++]; // 将较小值复制回原数组
            } else {
                arr[k] = temp[j++];// 将较小值复制回原数组
            }
        }
        while (i <= mid) { // 将mid左子序列剩余元素依次复制回原数组
            arr[k++] = temp[i++];
        }
        while (j <= right) { // 将mid右子序列剩余元素依次复制回原数组
            arr[k++] = temp[j++];
        }
    }
}
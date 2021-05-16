import java.util.Arrays;

public class RainbowSort {
    /**
     * 条件一：i = 0 ，i 的左侧(不包含 i) 是全是 a
     * 条件二：j = 0 ，j 为当前 index [i,j)全是 b
     * 条件三：(k = n - 1]， k 的右侧全是 c
     * [j-k]为未知探索区域
     * @param args
     */
    public static void main(String[] args) {
        char[] arr = {'b', 'b', 'c', 'c', 'a', 'b', 'a'};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(char[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k) { //探索未知区域
            if (arr[j] == 'a') {
                swap(arr, i, j); //不满足条件二和i进行交换
                i++; //i指针后移，满足条件
                j++; //j++,继续探索未知区域
            } else if (arr[j] == 'b') {
                j++;//满足条件，继续探索未知区域
            } else if (arr[j] == 'c') {
                swap(arr, j, k);//不满足条件三和k交换
                k--;//k--,继续探索未知区域
            }
        }
    }

    public static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
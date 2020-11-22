import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    /**
     * 在快排中，选择一个合适的pivot可以减少树的高度对算法效率有关键的提升
     * 因为初始序列是有序或逆序的时候，取左或取右作为pivot的两种方法都会使算法的效率变为最差，即树高为n,时间复杂度：O(n^2)
     * 而取pivot可以有多种方式如：头，中，尾，三数取中，随机
     * 这里我们用随机方式取pivot,其它思路大致
     * 随机法：使用随机数生成一个随机数index，随机数的范围为[left, right]
     * 并用此随机数为下标对应的元素a[index]作为pivot并与数组元素a[left]交换
     */

    public static void main(String[] args) {
        int[] arr = {7, 2, 8, 3, 4, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int height) {
        if (low < height) {  //base case
            int pivot = partition(arr, low, height);
            //对pivot左边再进行快排
            quickSort(arr, low, pivot - 1);
            //对pivot右边边再进行快排
            quickSort(arr, pivot + 1, height);
        }
    }

    public static int partition(int[] a, int low, int height) {
        //在partition搜索范围中随机生成一个作为pivot的元素下标
        int index = random(low, height);
        //将pivot与a[low]交换，使pivot都是partition中最左端那个值
        swap(a, low, index);

        int pivot = a[low];
        while (low < height) {  //low和height确定搜索范围
            while (low < height && a[height] >= pivot) --height;
            a[low] = a[height]; //找到比pivot小的数，移动到左端
            while (low < height && a[low] <= pivot) ++low;
            a[height] = a[low]; //找到比pivot大的数，移动到右端
        }
        // 因为我们每次在partition中选取的pivot都是最左端那个值
        // 所以最终只要我们把low和height指向的那个位置换成pivot
        // 就保证了partition中 左边 < pivot < 右边
        a[low] = pivot;
        // 返回pivot的位置
        return low;
    }

    public static int random(int low, int height) {
        // 在给定范围内生成一个随机数
        return low + (int) (Math.random() * (height - low + 1));
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

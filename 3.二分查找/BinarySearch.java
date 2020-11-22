import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binary_search(arr, 4);
        System.out.println(i);
    }

    public static int binary_search(int[] arr, int target) {
        int low = 0, height = arr.length - 1, mid;
        while (low <= height) {
            mid = (low + height) / 2; //取mid
            if (arr[mid] == target) { //mid为目标元素直接返回
                return mid;
            } else if (arr[mid] > target) { //目标元素小于mid,查找mid前半部分
                height = mid - 1;
            } else { //查找mid后半部分
                low = mid + 1;
            }
        }
        return -1;
    }


}
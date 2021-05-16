import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2,1,4,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

/*
  思想：每次筛出一个全局中最小的元素，放在没有排好序的最左端
  举例：int[] arr = {2,3,1,4};
  loop 1:在没有排序的范围里筛选出最小值为 1 和没有排序的 arr[0] = 2 互换，即 {2,3,1,4} => 1,{3,2,4}
  loop 2:在没有排序的范围里筛选出最小值为 2 和没有排序的 arr[1] = 3 互换，即 1,{3,2,4} => 1,2,{3,4}
  loop 3:在没有排序的范围里筛选出最小值为 3 和没有排序的 arr[2] = 3 互换，即 1,2,{3,4} => 1,2,3,{4}
  完成排序 {1,2,3,4}
*/
    static void selectionSort(int[] arr) {
        int globalMin, temp;
        for (int i = 0; i < arr.length - 1; i++) { // 外层循环控制需要迭代多少次
            globalMin = i;
            for (int j = i + 1; j < arr.length; j++) { // 内层循环找出搜索范围内最小的index
                if (arr[j] < arr[globalMin]) {
                    globalMin = j;
                }
            }
            //交换（将范围内最小值和没有排好序的最左端交换）
            temp = arr[i];
            arr[i] = arr[globalMin];
            arr[globalMin] = temp;
        }
    }
}

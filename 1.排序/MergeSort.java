import java.util.Vector;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 8, 9, 10, 3, 4, 6};
        Vector solution = mergeSort(arr, 0, arr.length - 1);
        System.out.println(solution.toString());
    }

    /**
     * 思想：分治法，将问题分成一些小的问题然后递归求解。
     * 举例：将两个已经有序的子序列合并成一个有序序列，比如要将[4,5,7,8]和[1,2,3,6]两个已经有序的子序列，合并为最终序列[1,2,3,4,5,6,7,8]
     */

    public static Vector mergeSort(int[] arr, int left, int right) {
        //最终返回的结果
        Vector<Integer> solution = new Vector<>();
        //base case 只有一个直接返回
        if (left == right) {
            solution.add(arr[left]);
            return solution;
        }
        //采用（ left + right ）/2 方式，数值较大可能会溢出
        int mid = left + (right - left) / 2;
        Vector<Integer> solution_left = mergeSort(arr, left, mid);//排好序的左子列
        //break point
        Vector<Integer> solution_right = mergeSort(arr, mid + 1, right);//排好序的右子列
        //break point
        return combine(solution_left, solution_right);
    }

    private static Vector<Integer> combine(Vector<Integer> solution_left, Vector<Integer> solution_right) {
        Vector<Integer> solution = new Vector<>();
        //例：将两个有序子列[4,5,7,8]和[1,2,3,6]初始化两个指针，按位比较大小存入solution
        int i = 0, j = 0;
        while (i < solution_left.size() && j < solution_right.size()) {
            if (solution_left.get(i) < solution_right.get(j)) {
                solution.add(solution_left.get(i));
                i++;
            } else {
                solution.add(solution_right.get(j));
                j++;
            }
        }
        //将剩余的元素全部加入solution
        while (i < solution_left.size()) {
            solution.add(solution_left.get(i));
            i++;
        }
        while (j < solution_right.size()) {
            solution.add(solution_right.get(j));
            j++;
        }
        return solution;
    }

}
> java:

```java
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
//call:
int[] arr = {2,1,4,5};
selectionSort(arr);
System.out.println(Arrays.toString(arr));//output:[1, 2, 4, 5]
```

> java 版本一:

```java
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

//call
int[] arr = {2, 1, 4, 5, 8, 9, 10, 3, 4, 6};
Vector solution = mergeSort(arr, 0, arr.length - 1);
System.out.println(solution.toString());//output:[1, 2, 3, 4, 4, 5, 6, 8, 9, 10]
```

> java 版本二:

```java
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
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
//call
int[] arr = {2, 1, 4, 5, 8, 9, 10, 3, 4, 6};
sort(arr);
System.out.println(Arrays.toString(arr));//output:[1, 2, 3, 4, 4, 5, 6, 8, 9, 10]
```

> java 版本三（复习补充）：

```java
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
//call
int[] arr = {7, 2, 8, 3, 4, 9};
sort(arr);
System.out.println(Arrays.toString(arr));
//output
[2, 3, 4, 7, 8, 9]
```

> java:

```java
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
//call
int[] arr = {1, 2, 8, 3, 4, 9};
quickSort(arr);
System.out.println(Arrays.toString(arr));
//output
[1, 2, 3, 4, 8, 9]
```

> java 实现思路：

我们讲快速排序结合一个例子来说明，假设我们现在对“6 1 2 7 9 3 4 5 10 8”这个 10 个数进行排序。首先在这个序列中随便找一个数作为基准数（不要被这个名词吓到了，就是一个用来参照的数，待会你就知道它用来做啥的了）。为了方便，就让第一个数 6 作为基准数吧。接下来，需要将这个序列中所有比基准数大的数放在 6 的右边，比基准数小的数放在 6 的左边，类似下面这种排列。

3 1 2 5 4 **6** 9 7 10 8

在初始状态下，数字 6 在序列的第 1 位。我们的目标是将 6 挪到序列中间的某个位置，假设这个位置是 k。现在就需要寻找这个 k，并且以第 k 位为分界点，左边的数都小于等于 6，右边的数都大于等于 6。想一想，你有办法可以做到这点吗？

方法其实很简单：分别从初始序列“6 1 2 7 9 3 4 5 10 8”两端开始“探测”。先从右往左找一个小于 6 的数，再从左往右找一个大于 6 的数，然后交换他们。这里可以用两个变量 i 和 j，分别指向序列最左边和最右边。我们为这两个变量起个好听的名字“哨兵 i”和“哨兵 j”。刚开始的时候让哨兵 i 指向序列的最左边（即 i=1），指向数字 6。让哨兵 j 指向序列的最右边（即 j=10），指向数字 8。

![20161016095048861.png](https://i.loli.net/2020/11/08/BSqbwenpXF6ZWN8.png)

首先哨兵 j 开始出动。因为此处设置的基准数是最左边的数，所以需要让哨兵 j 先出动，这一点非常重要（请自己想一想为什么）。哨兵 j 一步一步地向左挪动（即 j--），直到找到一个小于 6 的数停下来。接下来哨兵 i 再一步一步向右挪动（即 i++），直到找到一个数大于 6 的数停下来。最后哨兵 j 停在了数字 5 面前，哨兵 i 停在了数字 7 面前。

![2.png](https://i.loli.net/2020/11/08/j1CtcDsgSuVMxBb.png)

现在交换哨兵 i 和哨兵 j 所指向的元素的值。交换之后的序列如下。

6 1 2 **5** 9 3 4 **7** 10 8

![3.png](https://i.loli.net/2020/11/08/Xlyatk4dJFVvDU5.png)

到此，第一次交换结束。接下来开始哨兵 j 继续向左挪动（再友情提醒，每次必须是哨兵 j 先出发）。他发现了 4（比基准数 6 要小，满足要求）之后停了下来。哨兵 i 也继续向右挪动的，他发现了 9（比基准数 6 要大，满足要求）之后停了下来。此时再次进行交换，交换之后的序列如下。

6 1 2 5 **4** 3 **9** 7 10 8

第二次交换结束，“探测”继续。哨兵 j 继续向左挪动，他发现了 3（比基准数 6 要小，满足要求）之后又停了下来。哨兵 i 继续向右移动，糟啦！此时哨兵 i 和哨兵 j 相遇了，哨兵 i 和哨兵 j 都走到 3 面前。说明此时“探测”结束。我们将基准数 6 和 3 进行交换。交换之后的序列如下。

**3** 1 2 5 4 **6** 9 7 10 8

![4.png](https://i.loli.net/2020/11/08/RlOCISiedsNWcfQ.png)

到此第一轮“探测”真正结束。此时以基准数 6 为分界点，6 左边的数都小于等于 6，6 右边的数都大于等于 6。回顾一下刚才的过程，其实哨兵 j 的使命就是要找小于基准数的数，而哨兵 i 的使命就是要找大于基准数的数，直到 i 和 j 碰头为止。
OK，解释完毕。现在基准数 6 已经归位，它正好处在序列的第 6 位。此时我们已经将原来的序列，以 6 为分界点拆分成了两个序列，左边的序列是“3 1 2 5 4”，右边的序列是“9 7 10 8”。接下来还需要分别处理这两个序列。因为 6 左边和右边的序列目前都还是很混乱的。不过不要紧，我们已经掌握了方法，接下来只要模拟刚才的方法分别处理 6 左边和右边的序列即可。现在先来处理 6 左边的序列现吧。
左边的序列是“3 1 2 5 4”。请将这个序列以 3 为基准数进行调整，使得 3 左边的数都小于等于 3，3 右边的数都大于等于 3。好了开始动笔吧。
如果你模拟的没有错，调整完毕之后的序列的顺序应该是。

2 1 **3** 5 4

OK，现在 3 已经归位。接下来需要处理 3 左边的序列“2 1”和右边的序列“5 4”。对序列“2 1”以 2 为基准数进行调整，处理完毕之后的序列为“1 2”，到此 2 已经归位。序列“1”只有一个数，也不需要进行任何处理。至此我们对序列“2 1”已全部处理完毕，得到序列是“1 2”。序列“5 4”的处理也仿照此方法，最后得到的序列如下。

1 2 3 4 5 6 9 7 10 8

对于序列“9 7 10 8”也模拟刚才的过程，直到不可拆分出新的子序列为止。最终将会得到这样的序列，如下。

1 2 3 4 5 6 7 8 9 10

到此，排序完全结束。细心的同学可能已经发现，快速排序的每一轮处理其实就是将这一轮的基准数归位，直到所有的数都归位为止，排序就结束了。

[原文转载：坐在马桶上看算法—快速排序](https://blog.csdn.net/afjaklsdflka/article/details/52829030)
[参考：漫画-快速排序](https://blog.csdn.net/libaineu2004/article/details/82253412)

> java 版本一:

```java
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
//call
int[] arr = {1, 2, 8, 3, 4, 9};
quickSort(arr);
System.out.println(Arrays.toString(arr));
//output
[1, 2, 3, 4, 8, 9]
```

> java 版本二（复习补充）：

```java
   /**
     * 在快排中，选择一个合适的pivot可以减少树的高度对算法效率有关键的提升
     * 因为初始序列是有序或逆序的时候，取左或取右作为pivot的两种方法都会使算法的效率变为最差，即树高为n,时间复杂度：O(n^2)
     * 而取pivot可以有多种方式如：头，中，尾，三数取中，随机
     * 这里我们用随机方式取pivot,其它思路大致
     * 随机法：使用随机数生成一个随机数index，随机数的范围为[left, right]
     * 并用此随机数为下标对应的元素a[index]作为pivot并与数组元素a[left]交换
     */

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
//call
int[] arr = {7, 2, 8, 3, 4, 9};
quickSort(arr, 0, arr.length - 1);
System.out.println(Arrays.toString(arr));
//output
[2, 3, 4, 7, 8, 9]
```

> java：

```java
   /**
     * 条件一：i = 0 ，i 的左侧(不包含 i) 是全是 a
     * 条件二：j = 0 ，j 为当前 index [i,j)全是 b
     * 条件三：(k = n - 1]， k 的右侧全是 c
     * [j-k]为未知探索区域
     */
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
//call
char[] arr = {'b', 'b', 'c', 'c', 'a', 'b', 'a'};
sort(arr);
System.out.println(Arrays.toString(arr));
//output
[a, a, b, b, b, c, c]
```

> java：

```java
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
//call
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int i = binary_search(arr, 4);
System.out.println(i);
//output
3
```

java:

```java
 public static int[] findMatrix(int[][] arr, int target) {
        if (arr.length == 0 || arr[0].length == 0) {
            return new int[0];
        }
        int row = arr.length;
        int col = arr[0].length;
        int low = 0, mid = 0;
        int height = row * col - 1;//将二维数组拉成一维数组
        while (low <= height) {
            mid = (low + height) / 2;
            int _row = mid / col; //mid索引所在的行
            int _col = mid % col; //mid索引所在的列
            if (arr[_row][_col] == target) { //mid为目标元素直接返回
                return new int[]{_row, _col};
            } else if (arr[_row][_col] > target) { //目标元素小于mid,查找mid前半部分
                height = mid - 1;
            } else { //查找mid后半部分
                low = mid + 1;
            }
        }
        return new int[0];

    }
//call
 int[][] matrix = {
    {1, 2, 3, 4, 5},
    {6, 7, 8, 9, 10}
 };
 int[] res = findMatrix(matrix, 7);
 System.out.println(Arrays.toString(res));
//output
[1, 1]
```

> 应用： 如果需要对一个字符串或者数组不断回头看左边最新元素时往往要用到 Stack

> 顺序栈的实现：

java:

```java
/**
 * 顺序表实现栈：静态数组实现，并且记录栈顶指针
 */
public class SeqStack<T>{

    /**
     * 栈顶指针,-1代表空栈
     */
    private int top = -1;

    /**
     * 容量大小默认为10
     */
    private int capacity = 10;

    /**
     * 存放元素的数组
     */
    private T[] array;

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean push(T data) {
        if (top == capacity - 1) {
            //栈满返回失败或进行数组扩容
            return false;
        }
        //指针+1,加入新元素
        array[++top] = data;
        return true;
    }

    public T peek() {
        if(isEmpty()){
            return null;
        }
        return array[top];
    }

    public T pop() {
        if(isEmpty()){
            return null;
        }
        //返回栈顶元素，指针-1
        //逻辑删除
        return array[top--];
    }
}
//call
 SeqStack<Integer> seqStack = new SeqStack<>();
 seqStack.push(1);
 seqStack.push(2);
 seqStack.push(3);
 System.out.println(seqStack.pop());
 System.out.println(seqStack.pop());
 System.out.println(seqStack.peek());
 System.out.println(seqStack.isEmpty());
 System.out.println(seqStack.pop());
//output
3
2
1
false
1
```

> 栈的应用：

1.括号匹配校验

```java
//括号合法性检查
    public static Boolean bracketCheck(String str) {
        SeqStack<Character> seqStack = new SeqStack<>();
        if (null != str && "" != str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                    //遇到左括号入栈
                    seqStack.push(chars[i]);
                } else {
                    //遇到了右括号
                    if (seqStack.isEmpty()) { //如果栈为空，说明此时扫到的右括号没有对应的左括号
                        return false; // 匹配失败
                    }

                    Character pop = seqStack.pop();
                    char topChar = pop.charValue();
                    //匹配校验
                    //如果栈顶不与当前右括号对应，匹配失败
                    if (chars[i] == ')' && topChar != '(') {
                        return false;
                    }
                    if (chars[i] == ']' && topChar != '[') {
                        return false;
                    }
                    if (chars[i] == '}' && topChar != '{') {
                        return false;
                    }
                    //继续循环，遍历下一个字符
                }
            }
            //所有字符都遍历完成
            //检查栈如果非空，说明没有没有左括号匹配的右括号出现，匹配失败
            return seqStack.isEmpty();
        }
        return false;
    }
//call
 String trueBracketstr = "{[()()]}";
 System.out.println(bracketCheck(trueBracketstr));
 String falseBracketstr = "{[()()]}}";
 System.out.println(bracketCheck(falseBracketstr));
//output
true
false
```

2.逆波兰表达式转换：

逆波兰表达是一种是由[波兰](https://zh.wikipedia.org/wiki/波兰)[数学家](https://zh.wikipedia.org/wiki/数学家)[扬·武卡谢维奇](https://zh.wikipedia.org/wiki/扬·武卡谢维奇)1920 年引入的数学表达式方式，在逆波兰记法中，所有[操作符](https://zh.wikipedia.org/wiki/運算子)置于[操作数](https://zh.wikipedia.org/wiki/操作数)的后面，因此也被称为**后缀表示法**。逆波兰记法不需要括号来标识操作符的优先级。

逆波兰记法中，操作符置于操作数的后面。例如表达“三加四”时，写作“3 4 + ”，而不是“3 + 4”。如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5 + ”：先 3 减去 4，再加上 5。使用逆波兰记法的一个好处是不需要使用括号。例如中缀记法中“3 - 4 * 5”与“（3 - 4）*5”不相同，但后缀记法中前者写做“3 4 5 _ - ”，无歧义地表示“3 (4 5 _) -”；后者写做“3 4 - 5 \* ”。

![生成后缀表达式.gif](https://i.loli.net/2020/12/13/OCLSPHJ6aMr7Ww5.gif)

java:

```java
 // 中缀表达式转后缀表达式
    public static String infixTopostfixExp(String str) {
        //运算符栈
        SeqStack<Character> operatorStack = new SeqStack<>(str.length());
        //存储后缀表达式
        StringBuilder postfixStr = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //1.遇到操作数 [0-9] 直接加入后缀表达式
            if (Character.isDigit(chars[i])) {
                postfixStr.append(chars[i]);
                continue;
            }

            //2.如果遇到界限符 ()
            if (chars[i] == '(') { //遇到 ( 直接入栈
                operatorStack.push(chars[i]);
                continue;
            } else if (chars[i] == ')') { //遇到 ) 需要依次弹出栈内运算符并加入后缀表达式，直至弹出(为止
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.pop().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    postfixStr.append(topOpt);
                }
                continue;
            }

            //3.遇到预算符 -+*/
            //依次弹出栈中优先级高于或等于当前运算符的所有运算符
            //如果碰到（ 或者 栈空则停止
            if (chars[i] == '-' || chars[i] == '+') {
                //由于这两个运算符优先级相等，且优先级最低，所以可以弹出栈内所有运算符
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.peek().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    postfixStr.append(operatorStack.pop().charValue());
                }
                // 然后将当前运算符压入栈中
                operatorStack.push(chars[i]);
                continue;
            }
            if (chars[i] == '*' || chars[i] == '/') {
                //高优先级的运算符
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.peek().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    //判断栈顶元素的优先级
                    if (topOpt == '*' || topOpt == '/') {
                        postfixStr.append(operatorStack.pop().charValue());
                    } else if (topOpt == '-' || topOpt == '+') {
                        //栈顶运算符低于当前运算符
                        break;
                    }
                }
                operatorStack.push(chars[i]);
                continue;
            }
        }

        //将栈中的所有运算符依次加入后缀表达式中
        while (!operatorStack.isEmpty()) {
            postfixStr.append(operatorStack.pop().charValue());
        }
        return postfixStr.toString();
    }
//call
String optStr = "((9/(5-(1+1)))*3)-(2+(1+1))";
String postfixExp = infixTopostfixExp(optStr);
System.out.println("原中缀表达式为：" + optStr);
System.out.println("中转后缀表达式为：" + postfixExp)
//output
//原中缀表达式为：((9/(5-(1+1)))*3)-(2+(1+1))
//中转后缀表达式为：9511+-/3*211++-
```

逆波兰表达式求值：

步骤：依次按顺序遍历表达式，然后遇到操作数入栈；遇到操作符时，操作数出栈，进行求值，然后将结果入栈；循环此过程直至处理完所有的表达式，则栈顶就是表达式的值。

注：此处为了方便学习，未考虑代码健壮性，如除数为 0 等。

![计算后缀表达式.gif](https://i.loli.net/2020/12/13/K4HlBg7Fn2oi1AS.gif)

```java
//计算后缀表达式值
    public static Integer calcPostfixExp(String str) {
        //操作数栈
        SeqStack<Integer> operatorStack = new SeqStack<>(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //1.遇到操作数 [0-9] 直接入栈
            if (Character.isDigit(chars[i])) {
                operatorStack.push(Integer.parseInt(String.valueOf(chars[i])));
                continue;
            }

            //遇到的是运算符，弹出两个操作数
            //先弹出的是右操作数，注意顺序
            int rightOpt = operatorStack.pop();
            int leftOpt = operatorStack.pop();
            if (chars[i] == '+') {
                operatorStack.push(leftOpt + rightOpt);
            } else if (chars[i] == '-') {
                operatorStack.push(leftOpt - rightOpt);
            } else if (chars[i] == '*') {
                operatorStack.push(leftOpt * rightOpt);
            } else if (chars[i] == '/') {
                operatorStack.push(leftOpt / rightOpt);
            }
        }
        return operatorStack.pop();
    }
//call
calcPostfixExp("9511+-/3*211++-")
//output
5
```

java:

```java
/**
 * 单链表node节点
 */
public class LNode<T> {
    public T data; //节点数据
    public LNode<T> next;//下一节点指针

    public LNode(){}

    public LNode(T data){
        this.data=data;
    }

    public LNode(T data, LNode<T> next){
        this.data=data;
        this.next=next;
    }

}
/**
 * 单链表，不带头节点实现
 */
public class SingleLinkedList<T> {
    private LNode head;

    public SingleLinkedList() {
    }

    public SingleLinkedList(LNode head) {
        this.head = head;
    }


    public boolean isEmpty() {
        //不带头节点，直接判断head是否为空
        return this.head == null;
    }

    /**
     * 按位序插入
     *
     * @param i    index 从1开始
     * @param data
     * @return
     */
    public boolean insert(int i, T data) {
        if (data == null || i < 1) {
            return false;
        }
        if (i == 1) {
            //不带头节点需要更改单链表节点指向
            LNode newNode = new LNode(data, this.head);
            this.head = newNode;
            return true;
        }
        //找到第index - 1个节点之后，插入元素
        LNode p = getNode(i - 1);
        if (p == null) { //i不合法，i-1节点是null,自然也无法插入i节点
            return false;
        }
        return insertNextNode(p, data);
    }

    /**
     * 尾插法，每次都从头遍历到尾节点，时间复杂度n^2
     * 需要优化，思路：增加一个记录尾节点的指针，插入尾节点后，更新指针
     * @param data
     * @return
     */
    public boolean add(T data) {
        if (data == null) {
            return false;
        }
        if (this.head == null) {
            this.head = new LNode<T>(data, this.head);
            return true;
        }
        LNode<T> p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        insertNextNode(p, data);
        return true;
    }

    /**
     * 指定节点后插入元素
     *
     * @param p
     * @param data
     * @return
     */
    public boolean insertNextNode(LNode p, T data) {
        if (p == null) {
            return false;
        }
        //创建新节点，同时指向p的next节点
        LNode newNode = new LNode(data, p.next);
        //将新节点挂在p节点后
        p.next = newNode;
        return true;
    }

    /**
     * 指定节点前插入元素
     *
     * @param p
     * @param data
     * @return
     */
    public boolean insertPriorNode(LNode p, T data) {
        if (p == null) {
            return false;
        }
        //单链表没有前驱节点所以可以把新节点和p节点的数据互换
        //复制p节点插入p节点之后
        LNode newNode = new LNode(p.data, p.next);
        //将新节点挂在p节点后
        p.next = newNode;
        //将p节点数据更新为插入节点数据，实现前插
        p.data = data;
        return true;
    }

    /**
     * 按位删除节点
     *
     * @param i 从1开始
     * @return
     */
    public T delete(int i) {
        if (i < 1) {
            return null;
        }
        T old;
        if (this.head != null && i >= 1) {
            if (i == 1) {
                old = (T) this.head.data;
                this.head = this.head.next;
                return old;
            }

            //找到第index - 1个节点之后，删除元素
            LNode p = getNode(i - 1);

            if (p == null || //i不合法，i-1节点是null,自然也无法删除i节点
                    p.next == null) { //p节点之后没有其它节点
                return null;
            }
            LNode q = p.next;//获取待删除的节点
            old = (T) q.data;// 返回删除节点的值
            p.next = q.next; // 将p的next指针指向删除节点的next指针，断开链接
            return old;
        }
        return null;

    }

    /**
     * 按位序查找
     *
     * @param i 从1开始
     * @return
     */
    public LNode getNode(int i) {
        if (i < 1) {// 位序不合法
            return null;
        }
        if (this.head != null && i >= 1) {
            if (i == 1) {
                return this.head;
            }
            //找到第i个节点
            LNode p;//指向当前扫描的节点
            int j = 1;//当前p指向的是第几个节点
            p = this.head; //从第一个节点开始扫描
            while (p != null && j < i) { //循环找到i个节点
                p = p.next;
                j++;
            }
            return p;
        }
        return null;
    }

    public T get(int i) {
        LNode node = getNode(i);
        if (node != null) {
            return (T) node.data;
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "(";
        LNode<T> pre = this.head;
        while (pre != null) {
            str += pre.data;
            pre = pre.next;
            if (pre != null) {
                str += ", ";
            }
        }
        return str + ")";
    }

    /**
     * 按值查找
     *
     * @param data
     * @return
     */
    public LNode locateNode(T data) {

        if (this.head != null && data != null) {
            LNode<T> p = this.head;
            while (p != null && !data.equals(p.data)) {
                p = p.next;
            }
            return p;
        }
        return null;
    }

    /*
     获取单链表长度
     */
    public int length() {
        int length = 0;
        LNode<T> p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }


}
//call
SingleLinkedList<Integer> list=new SingleLinkedList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
System.out.println(list.toString());
list.insert(2,22);
System.out.println(list.toString());
System.out.println(list.delete(3));
System.out.println(list.toString());
//output
(1, 2, 3, 4)
(1, 22, 2, 3, 4)
2
(1, 22, 3, 4)
```

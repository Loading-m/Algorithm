<!-- 目录开始 -->

### 码云地址: https://gitee.com/lmresp/Algorithm (国内快速访问)

## <a name="chapter-one" id="chapter-one"></a>一 目录

| 目录                                                                                         |
| -------------------------------------------------------------------------------------------- |
| [一 目录](#chapter-one)                                                                      |
| <a name="catalog-chapter-two" id="catalog-chapter-two"></a>[二 前言](#chapter-two)           |
| &emsp;[2.1 语言说明](#chapter-two-one)                                                       |
| &emsp;[2.2 学习攻略](#chapter-two-two)                                                       |
| &emsp;[2.3 关于 issue](#chapter-two-three)                                                   |
| <a name="catalog-chapter-three" id="catalog-chapter-three"></a>[三 排序算法](#chapter-three) |
| &emsp;[3.1 选择排序](#chapter-three-one)                                                     |
| &emsp;[3.2 归并排序](#chapter-three-two)                                                     |
| &emsp;[3.3 快速排序](#chapter-three-three)                                                   |
| &emsp;[3.4 RainbowSort](#chapter-three-four)                                                 |
| <a name="catalog-chapter-four" id="catalog-chapter-four"></a>[四 recursion I](#chapter-four) |
| &emsp;[4.1 斐波那契数列](#chapter-four-one)                                                  |
| &emsp;[4.2 a 的 b 次方(基础版)](#chapter-four-two)                                           |
| <a name="catalog-chapter-five" id="catalog-chapter-five"></a>[五 二分查找法](#chapter-five)  |
| &emsp;[5.1 寻找目标数字在排序数组中的索引](#chapter-five-one)                                |
| &emsp;[5.2 二维数组里是否存在某个数字](#chapter-five-two)                                    |
| &emsp;[5.3 寻找最接近 target 的值的索引](#chapter-five-three)                                |
| &emsp;[5.4 寻找最左边的 target 的值的索引](#chapter-five-four)                               |
| &emsp;[5.5 寻找最右边的 target 值的索引](#chapter-five-five)                                 |
| &emsp;[5.6 寻找最接近 target 的 7 个数字](#chapter-five-six)                                 |
| <a name="catalog-chapter-six" id="catalog-chapter-six"></a>[六 Stack & Queue](#chapter-six)  |
| &emsp;[6.1 用两个 stack 实现一个 Queue](#chapter-six-one)                                    |
| &emsp;[6.2 实现最小栈](#chapter-six-two)                                                     |
| <a name="catalog-chapter-seven" id="catalog-chapter-seven"></a>[七 链表](#chapter-seven)     |
| &emsp;[7.1 反转链表](#chapter-seven-one)                                                     |

<!-- 目录结束 -->

## <a name="chapter-two" id="chapter-two"></a>二 前言

> [返回目录](#chapter-one)

很多小伙伴对数据结构与算法有说不出来的畏惧感, 每当谈起时都闻声色变~, 其实一般就我们探讨的数据结构算法不需要高人一等的智商, 只是需要辅以一些小 trick 和一(亿)点点的练习就可以进步..., 故本人开了本仓库, 后面会持续更新 README.md, 和大家一起学习这个带有神秘面纱的"新事物"

### <a name="chapter-two-one" id="chapter-two-one"></a>2.1 语言说明

> [返回目录](#chapter-one)

1. 本项目均采用 javascript + java 进行代码编写

### <a name="chapter-two-two" id="chapter-two-two"></a>2.2 学习攻略

> [返回目录](#chapter-one)

1. 本项目代码中有注释的地方都是需要好好理解的部分(也是很多同鞋学习了很久都难以掌握的一些 corner case...), 只要结合注释认真理解后相信你会豁然开朗

2. 性质和思路需要先看, 看看是如何思考的~!

3. 最后再辅以代码和执行图 **相对较难理解的将会有图片辅助理解** 进行理解 + 练习(coding)

### <a name="chapter-two-three" id="chapter-two-three"></a>2.3 关于 issue

> [返回目录](#chapter-one)

对代码的实现有更优解(时间复杂度或空间复杂度更优) 可以根据分类 + 题名提交 issue 共同探讨

## <a name="chapter-three" id="chapter-three"></a>三 排序算法

> [返回目录](#chapter-one)

### <a name="chapter-three-one" id="chapter-three-one"></a>3.1 选择排序

> [返回目录](#chapter-one)

> javascript:

```typescript
const selectSort = (unSortedArr: number[]) => {
	for (let i = 0; i < unSortedArr.length - 1; i++) {
		//循环多少次
		let min = i
		for (let j = i + 1; j < unSortedArr.length; j++) {
			//寻找所有数组中最小的那个数不断更新最小值
			if (unSortedArr[j] < unSortedArr[min]) {
				min = j
			}
		}
		//交换 （最小值和未排好序的最左侧进行交换）
		;[unSortedArr[i], unSortedArr[min]] = [unSortedArr[min], unSortedArr[i]]
	}
}
//call:
selectSort([2, 1, 4, 5])
```

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

> 时间复杂度: 等差数列求和 结果为: O(n^2)

> 空间复杂度: O(1)

![selectionSort](https://i.loli.net/2020/11/10/jhSivbCYBuT6Rna.gif)

### <a name="chapter-three-two" id="chapter-three-two"></a>3.2 归并排序

![mergeSort1](https://i.ibb.co/JBytq39/php-At0-Xe-F.gif)

![mergeSort](https://i.loli.net/2020/10/29/6vKXIh15meGanqJ.png)

> [返回目录](#chapter-one)

> javascript

```typescript
const mergeSort = (arr: number[]) => {
	if (arr.length <= 1) return arr
	let length = arr.length
	let mid = (length / 2) | 0
	let left = mergeSort(arr.slice(0, mid))
	//bp
	let right = mergeSort(arr.slice(mid))
	return mergeHelper(left, right)
}
const mergeHelper = (leftArr: number[], rightArr: number[]) => {
	let i = 0
	let j = 0
	let result = []
	while (i < leftArr.length && j < rightArr.length) {
		if (leftArr[i] < rightArr[j]) {
			result.push(leftArr[i++])
		} else {
			result.push(rightArr[j++])
		}
	}
	while (i < leftArr.length) {
		result.push(leftArr[i++])
	}
	while (j < rightArr.length) {
		result.push(rightArr[j++])
	}
	return result
}
//call:
let arr = [2, 1, 4, 5, 8, 9, 10, 3, 4, 6]
mergeSort(arr)
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

>java 版本三（复习补充）：

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



> 时间复杂度: 每一次切一半 第一层 O(1) 第二层 O(2) 第三层 O(4)....最后一层 O(n)
> 合并时每一层都是 o(n) 有 logn 层 所以最终复杂度为 O(nlogn)

> 空间复杂度: 等比数列：n/2 + n/4 + n/8 + 1 = O(n)

### <a name="chapter-three-three" id="chapter-three-three"></a>3.3 快速排序

> js 实现思路： 是取第一个元素（或者最后一个元素）作为分界点，把整个数组分成左右两侧，左边的元素小于或者等于分界点元素，而右边的元素大于分界点元素，然后把分界点移到中间位置，对左右子数组分别进行递归，最后就能得到一个排序完成的数组。当子数组只有一个或者没有元素的时候就结束这个递归过程。其中最重要的是将整个数组根据分界点元素划分成左右两侧的逻辑
>
> ![quickSort](https://i.loli.net/2020/11/10/M1AxX4DafJNQwIY.gif)

[返回目录](#chapter-one)

性质：两个挡板三个区域

> [0...i) i 的左侧全部为比 pivot 小的数

> [i...j] i 和 j 之间为未知探索区域

> (j...n-1] j 的右侧全部为比 pivot 大或等于的数字

> javascript:

```typescript
function swap(arr: number[], i: number, j: number) {
	;[arr[i], arr[j]] = [arr[j], arr[i]]
}

function quickSort(arr: number[]) {
	if (!arr.length) {
		return arr
	}
	doQuickSort(arr, 0, arr.length - 1)
	return arr
}
function doQuickSort(arr: number[], left: number, right: number) {
	// base case:
	if (left >= right) {
		return
	}
	let pivot = partition(arr, left, right)
	doQuickSort(arr, 0, pivot - 1)
	doQuickSort(arr, pivot + 1, right)
}
function partition(arr: number[], left: number, right: number) {
	let pivotIdx = left + ((Math.random() * (right - left)) | 0) + 1
	let pivotElement = arr[pivotIdx]
	//交换pivot和最右边的值
	swap(arr, right, pivotIdx)
	let leftBound = left
	let rightBound = right - 1

	while (leftBound <= rightBound) {
		if (arr[leftBound] < pivotElement) {
			leftBound++
		} else if (arr[rightBound] >= pivotElement) {
			rightBound--
		} else {
			swap(arr, leftBound++, rightBound--)
		}
	}
	// i和 pivot交换
	swap(arr, leftBound, right)
	return leftBound
}
const result = quickSort([1, 2, 8, 3, 4, 9])
console.log(result)
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
>java 版本二（复习补充）：

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



### <a name="chapter-three-four" id="chapter-three-four"></a>3.4 RainbowSort

> [返回目录](#chapter-one)

> 将 abccbba 排序为： aabbbcc

性质：

> 物理意义： 三个挡板四个区域 （相应的如果题目中的字母类型更多那只需要加挡板划区间就可以了 一通百通）

> i = 0 i 的左侧(不包含 i) 是全是 a

> j = 0 j 为当前 index [i,j)全是 b

> (k = n - 1] k 的右侧全是 c

> [j-k]为未知探索区域

其实上面的问题可以转换为这：

![rainbow.png](https://i.loli.net/2020/11/10/c56CJsxzBqM3dOy.jpg)

```typescript
function swap(arr: number[], i: number, j: number) {
	;[arr[i], arr[j]] = [arr[j], arr[i]]
}
function rainbowSort(arr: number[]) {
	let i = 0,
		j = 0,
		k = arr.length - 1
	while (j <= k) {
		if (arr[j] === 'a') {
			swap(arr, i++, j++)
		} else if (arr[j] === 'b') {
			j++
		} else if (arr[j] === 'c') {
			swap(arr, j, k--)
		}
	}
	return arr
}
const result = rainbowSort(['a', 'b', 'c', 'c', 'b', 'b', 'a'])
console.log(result)
```

## <a name="chapter-four" id="chapter-four"></a>四 recursion I

> [返回目录](#chapter-one)

> recursion 空间复杂度计算方式： call stack 一共有多少层， 每一层里耗费了多少空间 所有加和就得到了空间复杂度

> recursion 时间复杂度计算方式： 每一层的节点个数，每一层每一层相加的结果

概念：

> 1.表象上是函数自己调用自己

> 2.实质上是把一个大问题缩小到比它小 n-1,or n-2 或更小的问题 然后合并小号问题得到大问题的解

实现：

> 1.base base: 最小的问题的解（不再依赖任何其他的 recursion 计算）

> 2.recursive rule: 用同样的规则处理更小号的问题

### <a name="chapter-four-one" id="chapter-four-one"></a>4.1 斐波那契数列

> [返回目录](#chapter-one)

> base case: F(0) = 0 F(1) = 1

> recursive rule: F(n) = F(n - 1) + F(n - 2)

```typescript
function fibo(n) {
	if (n === 0) return 0
	if (n === 1) return 1
	// 需要注意: 这里的fibo(n - 1) + fibo(n - 2)并不是同时计算的,而是fibo(n - 1)直下的执行到底,直到遇到base case往上反弹时才会调用fibo(n - 2),之后把结果return到上一层去
	return fibo(n - 1) + fibo(n - 2)
}
```

> 时间复杂度: 1 + 2 + 4 + 8 + 2^(n -1) = O(2^n)

> 空间复杂度： O(n) => calc method: how many push call stacks

![fibo](https://i.ibb.co/MBx6zkY/php-Jv-S1-Py.png)

> tips: 递归会记录每次调用之前的 local variable 的值
> 例如 fibo(n - 1) 调用前会记录 n 的值
> 所以计算 n-2 时才会知道 n 是几

### <a name="chapter-four-two" id="chapter-four-two"></a>4.2 a 的 b 次方(基础版)

> [返回目录](#chapter-one)

> 计算 2 的 1000 次方等于多少

> base case: b === 0 a^0 = 1

> recursion rule: F(n) = F(n / 2) \* F(n / 2)

```typescript
function a_pow_b(a: number, b: number) {
	//base case: b === 0  a^0 = 1
	if (b === 0) return 1
	let half_result = a_pow_b(a, (b / 2) | 0)
	if (b % 2 === 0) {
		return half_result * half_result
	} else {
		return half_result * half_result * a
	}
}
```

![a_pow_b](https://i.loli.net/2020/10/29/QXYwNudrqaK37kH.png)

> 时间复杂度： O(logb)

> 空间复杂度： O(logb)

## <a name="chapter-five" id="chapter-five"></a>五 二分查找法

> [返回目录](#chapter-one)

### <a name="chapter-five-one" id="chapter-five-one"></a>5.1 寻找目标数字在排序数组中的索引

> [返回目录](#chapter-one)

> 使用左闭右闭区间法 [l, r]

```typescript
const binarySearch = (arr: number[], target: number) => {
	let left = 0,
		right = arr.length - 1
	//假设arr只有一个元素，如果是 < 的话, 那么一个元素就会进不了while循环（就会直接return -1了 是错的） 所以是<=
	while (left <= right) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid - 1 //往左手边找 因为target比中间元素还要小 说明右边不可能再有元素符合条件了 所以往左手边小的数字里继续找(缩小范围)
		} else if (arr[mid] < target) {
			left = mid + 1 //往右手边找 因为target比中间元素还要大说明左边不可能再有元素符合条件了 所以往右手边大的数字里继续找(缩小范围)
		} else {
			return mid //找到了想要的数字
		}
	}
	return -1
}
const index = binarySearch([1, 2, 3, 4, 5, 6], 4)
console.log(index)
```

> 时间复杂度: O(logn)

> 空间复杂度: O(1)

### <a name="chapter-five-two" id="chapter-five-two"></a>5.2 二维数组里是否存在某个数字

> [返回目录](#chapter-one)

-   题目描述
-   给定一个只包含整数的二维矩阵，其每一行都按升序排序。下一行的第一个元素大于(或等于)前一行的最后一个元素.
-   给定一个目标数，返回目标在矩阵中的位置。如果矩阵中不存在目标数，则返回 { -1, -1 }.
-
-   假定:
-   给定矩阵不为零，其大小为 N \* M，其中 N >= 0, M >= 0.
-
-   例子:
-   matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
-   target = 7, return {1, 2}
-   target = 6, return { -1, -1 } 表示矩阵中不存在的目标数.

```
matrix:   1  2  3  4

          5  6  7  8

          9 10 11 12

target: 6
```

```typescript
const findMatrix = (matrix: number[][], target: number) => {
	// corner case
	if (matrix.length === 0 || matrix[0].length === 0) {
		return false
	}
	let row = matrix.length
	let col = matrix[0].length
	let i = 0,
		// 使用row * col将2维数组转换为1维数组
		j = row * col - 1
	while (i <= j) {
		let mid = ((i + (j - i)) / 2) | 0
		// 将一维数组中的位置转换为二维数组中的row和col
		let _row = mid / col
		let _col = mid % col
		if (matrix[_row][_col] === target) {
			return [_row, _col]
		} else if (matrix[_row][_col] > target) {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return [-1, -1]
}

const index = findMatrix(
	[
		[1, 2, 3, 4],
		[5, 6, 7, 8],
		[9, 10, 11, 12],
	],
	6
)
console.log(index)
```

### <a name="chapter-five-three" id="chapter-five-three"></a>5.3 寻找最接近 target 的值的索引

> [返回目录](#chapter-one)

```typescript
const binarySearchCloset = (arr: number[], target: number) => {
	//corner case
	if (!arr || arr.length == 0) return -1

	let left = 0,
		right = arr.length - 1
	//如果左不相邻右就持续while
	// (left === right - 1) 这是相邻的条件 相邻就停止
	//提前一步停下来
	while (left < right - 1) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid // // right = mid - 1; 这样是错误的，可能会忽略掉某些元素。比如[1,4,5] target = 3, 第二步会直接L=M=R，跳过了正确答案4，所以这里不能-1 tips: 每次缩小的区间你必须确定是以后绝对不会再使用到的那块区间
		} else if (arr[mid] < target) {
			left = mid // 这里也不能+1 原因同上
		} else {
			return mid //找到了想要的数字
		}
	}
	// 后续处理
	// 如果 |left位置的值 - t| 小于 |right位置的值 - t| 说明left更接近所以返回left
	if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
		return left
	} else {
		return right
	}
}
const number = binarySearchCloset([1, 3, 4, 7, 9], 5)
console.log(number)
```

### <a name="chapter-five-four" id="chapter-five-four"></a>5.4 寻找最左边的 target 的值的索引

> [返回目录](#chapter-one)

```typescript
const binarySearchLeft = (arr: number[], target: number) => {
	//corner case
	if (!arr || arr.length == 0) return -1
	let left = 0,
		right = arr.length - 1
	//如果左不相邻右就持续while
	// (left === right - 1) 这是相邻的条件 相邻就停止
	while (left < right - 1) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid // right=mid–1; right已经不是目标元素了，所以移位也会影响最终结果
		} else if (arr[mid] < target) {
			left = mid //同上
		} else {
			right = mid //arr[mid] === target = true 找到了target值但不要停下来， 还需要持续检查左边是否还有target 因为题意是要找最左侧的target值，所以mid-1是错的，因为可能当前找到的就只有这一个target元素
		}
	}
	// 后续处理
	// 因为是要找最左边的target 所以先检查左边界
	if (arr[left] === target) {
		return left
	} else {
		return right
	}
	return -1 // 如果左右都不相等，说明该元素不存在
}
const number = binarySearchLeft([1, 4, 5, 5, 5, 7, 9], 5)
console.log(number)
```

### <a name="chapter-five-five" id="chapter-five-five"></a>5.5 寻找最右边的 target 值的索引

> [返回目录](#chapter-one)

自己先做一遍， 检查下上面的题是否做到了真正理解！

```typescript
const binarySearchRight = (arr: number[], target: number) => {
	//corner case
	if (!arr || arr.length == 0) return -1
	let left = 0,
		right = arr.length - 1
	//如果左不相邻右就持续while
	// (left === right - 1) 这是相邻的条件 相邻就停止
	while (left < right - 1) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid
		} else if (arr[mid] < target) {
			left = mid
		} else {
			left = mid //arr[mid] === target = true 找到了target值但不要停下来， 还需要持续检查右边是否还有target 因为题意是要找最右侧的target值
		}
	}
	// 后续处理
	// 因为是要找最右边的target 所以先检查右边界
	if (arr[right] === target) {
		return right
	} else {
		return left
	}
	return -1
}
const number = binarySearchRight([1, 4, 5, 5, 5, 7, 9], 5)
console.log(number)
```

> [返回目录](#chapter-one)

### <a name="chapter-five-six" id="chapter-five-six"></a>5.6 寻找最接近 target 的 7 个数字

> [返回目录](#chapter-one)

-   给定目标整数 T，非负整数 K 和按升序排序的整数数组 A，找到 A 中最接近 T 的 K 个数字。 如果存在平局，则始终首选较小的元素。
-
-   假设:
-   arr 不为空
-   K 保证大于等于 0，K 保证小于等于 arr.length
-   返回大小为 K 的整数数组，其中包含 arr 中的 K 个最接近的数字（不是索引），并按数字和 target 之间的差值升序排列。
-
-   例子:
-   arr = [1，2，3]，target = 2，K = 3，返回[2，1，3]或[2，3，1]
-   arr = [1，4，6，8]，，target = 3，K = 3，返回[4，1，6]

> 思路： 按照上面的套路， 肯定是先找到最接近 target 的那个数字的索引， 然后双指针往两边扩散， 哪个数字更接近 target 就 push 到结果数组中

```typescript
const findKthCloset = (arr: number[], target: number, k: number) => {
	//沿用上面的模板, 找到最接近的那个值
	let left = 0,
		right = arr.length - 1
	while (left < right - 1) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid
		} else if (arr[mid] < target) {
			left = mid
		} else {
			left = mid
		}
	}
	let closetIdx = 0 //找到最接近的第一个数字 要么是左 要么是右 存储它的索引
	// 后续处理
	if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
		closetIdx = left
	} else {
		closetIdx = right
	}
	let result = [] //需要返回的结果数组
	let l = closetIdx //左边界
	let r = closetIdx + 1 //右边界
	//找K个数
	for (let i = 0; i < k; i++) {
		//如果右边界已经没有元素，则让左边的一个元素进来
		if (r >= arr.length) {
			result.push(arr[l--])
		} else if (l < 0) {
			//如果左边界没有元素，则让右边的一个元素进来
			result.push(arr[r++])
		} else if (Math.abs(arr[l] - target) <= Math.abs(arr[r] - target)) {
			// 如果都有元素就看谁更接近
			result.push(arr[l--])
		} else {
			result.push(arr[r++])
		}
	}
	return result
}
const result = findKthCloset([1, 4, 5, 7, 8, 9, 11], 5, 3)
console.log(result)
```

> 时间复杂度: O(logn + k)

## <a name="chapter-six" id="chapter-six"></a>六 Stack & Queue

> [返回目录](#chapter-one)

> 应用： 如果需要对一个字符串或者数组不断回头看左边最新元素时往往要用到 Stack

### <a name="chapter-six-one" id="chapter-six-one"></a>6.1 用两个 stack 实现一个 Queue

> [返回目录](#chapter-one)

-   描述：
-   通过使用两个栈实现一个队列。队列应该提供 size()、isEmpty()、offer()、poll()和 peek()操作。当队列为空时，poll()和 peek()应该返回 null
-
-   假设：
-   队列中的元素都是整数.
-   size()应该返回队列中的元素数量.
-   如果队列中没有缓冲元素，isEmpty()应该返回 true，否则返回 false.
-
-   要求：
-   offer()方法的时间复杂度应该是 O(1)

> 思路:

> inStack: 用来做缓冲，只要是有元素往里进的时候就加到 inStack 里

> outStack:

> 1）如果 outStack 是空的， 然后将所有元素一个接一个的从 inStack 放到 outStack 中， 然后从 outStack 中 弹出顶部元素

> 2）如果 outStack 不是空的，然后直接调用 outStack 的弹出

> 时间复杂度：

> push() : O(1) pop() : O(n)

```typescript
class QueueByTwoStacks<T = number> {
	private in: T[]
	private out: T[]

	public constructor() {
		this.in = []
		this.out = []
	}

	public poll(): T {
		//如果out栈为空，则需要将元素从in栈移到out栈
		this.shuffle()
		if (!this.out.length) {
			return null
		} else {
			return this.out.pop()
		}
	}

	public offer(value: T): void {
		this.in.push(value) //总是推到栈中
	}

	public peek(): T {
		this.shuffle()
		if (!this.out.length) {
			return null
		} else {
			return this.out[this.out.length - 1]
		}
	}

	public size(): number {
		return this.in.length + this.out.length
	}

	public isEmpty(): boolean {
		return !this.in.length && !this.out.length
	}

	//当out栈为空时，将元素从in栈转移到out栈
	public shuffle(): void {
		if (!this.out.length) {
			while (this.in.length) {
				this.out.push(this.in.pop())
			}
		}
	}
}

const queue = new QueueByTwoStacks()
queue.offer(1)
queue.offer(2)
queue.offer(3)
console.log(queue.poll()) // 1
console.log(queue.poll()) // 2
console.log(queue.peek()) // 3
console.log(queue.isEmpty()) //false
console.log(queue.poll()) //3
```

### <a name="chapter-six-two" id="chapter-six-two"></a>6.2 实现最小栈

> [返回目录](#chapter-one)

-   要求描述：
-   增强栈实现以支持 min()操作。min()应该返回堆栈中的当前最小值。如果堆栈是空的，min()应该返回-1
-   pop() - 删除并返回顶部元素，如果栈为空，则返回-1
-   push(int element) - 将元素推到顶部
-   top() - 返回顶部元素而不删除它，如果栈是空的，返回-1
-   min() - 返回栈中的当前最小值
-
-   尝试使 minStack 中的元素按降序排列，并在 minStack 中以这种格式存储元素 <value, 将该元素添加到 minStack 时 stack 的大小>

> 思路:

-   Stack || 3 3 3 2 1 0 3 1 -7 3 1 -7 -7 -6 -8
-   minStack|| <3,1> <2,4> <1,5> <0,6>,<-7,9>,<-8,15>

> 一个数字进来时判断是不是比 minStack 栈顶的元素小，如果小则放到栈顶， pop 的时候判断如果栈顶的元素和最小栈栈顶的元素相同并且时入栈时的大小就删除掉最小栈里的元素

```typescript
var MinStack = function () {
	this.stack = []
	this.minStack = []
}

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
	this.stack.push(x)
	if (this.minStack.length === 0 || x < this.minStack[this.minStack.length - 1][0]) {
		this.minStack.push([x, this.stack.length])
	}
}

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
	if (!this.stack.length) return -1
	let stackTopValue = this.stack[this.stack.length - 1]
	let minStackTop = this.minStack[this.minStack.length - 1]
	if (stackTopValue === minStackTop[0] && minStackTop[1] === this.stack.length) {
		this.minStack.pop()
	}
	this.stack.pop()
}

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
	return this.stack.length ? this.stack[this.stack.length - 1] : -1
}

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
	return this.minStack.length ? this.minStack[this.minStack.length - 1][0] : -1
}
```

## <a name="chapter-seven" id="chapter-seven"></a>七 链表

> [返回目录](#chapter-one)

> 要点：
>
> 1.避免访问空值
>
> 2.永远不要失去对 LinkedList 头的所有权(无论是删除节点，增加节点，以及任何其他改变)

### <a name="chapter-seven-one" id="chapter-seven-one"></a>7.1 反转链表

> [返回目录](#chapter-one)

<!-- 目录开始 -->

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

### <a name="chapter-three-two" id="chapter-three-two"></a>3.2 归并排序

> [返回目录](#chapter-one)

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

![mergeSort](https://github.com/Dreams-d/Algorithm/blob/master/mergeSort.png)

> 时间复杂度: 每一次切一半 第一层 O(1) 第二层 O(2) 第三层 O(4)....最后一层 O(n)
> 合并时每一层都是 o(n) 有 logn 层 所以最终复杂度为 O(nlogn)

> 空间复杂度: 等比数列：n/2 + n/4 + n/8 + 1 = O(n)

### <a name="chapter-three-three" id="chapter-three-three"></a>3.3 快速排序

> [返回目录](#chapter-one)

性质：两个挡板三个区域

> [0...i) i 的左侧（不包含 i）全部为比 pivot 小的数

> [i...j] i 和 j 之间为未知探索区域

> (j...n-1] j 的右侧（不包含 j）全部为比 pivot 大或等于的数字

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

### <a name="chapter-three-four" id="chapter-three-four"></a>3.4 RainbowSort

> [返回目录](#chapter-one)

> 将 abccbba 排序为： aabbbcc

性质：

> 物理意义： 三个挡板四个区域 （相应的如果题目中的字母类型更多那只需要加挡板划区间就可以了 一通百通）

> i = 0 i 的左侧(不包含 i) 是全是 a

> j = 0 j 为当前 index [i,j)全是 b

> (k = n - 1] k 的右侧全是 c

> [j-k]为未知探索区域

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

![fibo](https://github.com/Dreams-d/Algorithm/blob/master/fibo.png)

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

![a_pow_b](https://github.com/Dreams-d/Algorithm/blob/master/a_pow_b.png)

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

> 思路：把二维的数组映射为一维的

```
matrix:   1  2  3  4

          5  6  7  8

          9 10 11 12

target: 6
```

```typescript
const findMatrix = (matrix: number[][], target: number) => {
	if (matrix.length === 0 || matrix[0].length === 0) {
		return false
	}
	let row = matrix.length
	let col = matrix[0].length
	let i = 0,
		j = row * col - 1
	while (i <= j) {
		let mid = ((i + (j - i)) / 2) | 0
		let _row = mid / col // map two-dimension matrix row
		let _col = mid % col // map two-dimension matrix col
		if (matrix[_row][_col] === target) {
			return true
		} else if (matrix[_row][_col] > target) {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return false
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
	let left = 0,
		right = arr.length - 1
	//如果左不相邻右就持续while
	// (left === right - 1) 这是相邻的条件 相邻就停止
	while (left < right - 1) {
		let mid = (left + (right - left) / 2) | 0
		if (arr[mid] > target) {
			right = mid // 这里不能-1 是因为-1有可能会错过最接近的值(这道题是要找最接近的值) tips: 每次缩小的区间你必须确定是绝对不会再使用到的那块区域
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
			right = mid //arr[mid] === target = true 找到了target值但不要停下来， 还需要持续检查左边是否还有target 因为题意是要找最左侧的target值
		}
	}
	// 后续处理
	// 因为是要找最左边的target 所以先检查左边界
	if (arr[left] === target) {
		return left
	} else {
		return right
	}
	return -1
}
const number = binarySearchLeft([1, 4, 5, 5, 5, 7, 9], 5)
console.log(number)
```

### <a name="chapter-five-five" id="chapter-five-five"></a>5.5 寻找最右边的 target 值的索引

> [返回目录](#chapter-one)

自己先做一遍， 检查下上面的题是否做到了真正理解！

```typescript
const binarySearchRight = (arr: number[], target: number) => {
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
			return mid
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

## Stack & Queue

## 更新...

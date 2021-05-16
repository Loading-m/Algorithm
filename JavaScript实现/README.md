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

> javaScript:

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

> 动画演示，例：寻找目标元素 73
> ![BinarySearch.gif](https://i.loli.net/2020/11/22/Jm8n15Cf9MPwY3s.gif)

> javaScript 使用左闭右闭区间法 [l, r]：

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

matrix: 1 2 3 4

          5  6  7  8

          9 10 11 12

target: 6

```

javaScript:

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
			right = mid // right=mid–1; right已经不是目标元素了，所以移位也不会影响最终结果
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
	} else if (arr[right] === target) {
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
	} else if (arr[left] === target) {
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

> 单链表实现(不带头节点):

### <a name="chapter-seven-one" id="chapter-seven-one"></a>7.1 反转链表

> [返回目录](#chapter-one)

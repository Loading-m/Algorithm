

# 数组面试专题


从题库高频考题以及刷题过程的总结，可以分析出在面试中对于数组部分可以简分为四个部分：

1. 双指针
2. 排序
3. 二分法
4. 特性

大部分解题思路都是由上述特定的解决技巧所组合而成的，只有不断的将基础思想根深蒂固后，才能有非常大的把握去挑战更为复杂的问题。

> 为了更贴合实际面试感觉，所思所想全部以注释形式给出（自己撸题时候留下的印迹...）

## 速揽

TODO: 速揽

## 双指针

虽然指针问题看似简单，但有些时候处理起来还是相对棘手（菜原罪），以如下4道基础指针（也是非常高频）问题，快速回顾和练习解题套路！

### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

- 字节跳动|14
- Facebook 脸书|12
- 亚马逊 Amazon|10
- 苹果 Apple|5
- 微软 Microsoft|4
- 谷歌 Google|2
- 滴滴打车|2
- PayPal|2
- 特斯拉 Tesla|2

```js
/**
 *    |
 *    0 1 0 3 12
 *    ^  
 * 
 *    |                      |
 *    0 1 0 3 12    -> 交换 1 0 0 3 12
 *      ^                    ^
 * 
 * 
 *      |          
 *    1 0 0 3 12   
 *          ^      
 * 
 *      |          
 *    1 0 0 3 12  -> 交换 ...
 *          ^      
 * 
 * 因此：解决问题的两个关键点：
 * 
 *  1. 何时交换？ 当^指针指向的元素值不为0就交换，交换完毕后需要将|挡板向前移动
 *  2. 何时skip? 当^指针指向的元素的为0时，只有^指针移动
 *  3. 交换可以取巧直接拿值和0进行交换
 *  
 * 
 * 
 */
var moveZeroes = function(nums) {
  let i = 0, // | 挡板
      j = 0; // ^ 遍历指针
  for(;j < nums.length;j++) {
    if(nums[j] !== 0) {
      // swap逻辑
      // cornercase: i = 0, j = 0, eg:[1,0]
      if(i < j) {
      // 取巧的"swap"
        nums[i] = nums[j]
        nums[j] = 0;
      }
      i++
    }
    // === 0 进行skip
  }
};
```

### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

- Facebook 脸书|52
- 字节跳动|15
- 微软 Microsoft|13
- 亚马逊 Amazon|13
- 苹果 Apple|6
- 腾讯 Tencent|6
- 快手|4
- 小米|3
- IBM|3
- 美团点评|3

```js
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */

/**
 *
  
  之所以从尾巴开始比较，是为了将结果比较大的元素添加到nums1的尾部，这样避免了“搬移数组”

  搬移数组是说，如果从小到大比较并移动元素的话，需要将元素向后串移（不太理解的简单跑一下从小到大即可）

            v     ！
       [3,4,5,0,0,0]

       [1,2,3]
            ^

v 指针物理意义：nums1 需要被比较的元素，当nums1移动(左移)到数组头部时（< 0） 则不再考虑移动。
^ 指针物理意义：nums1 需要被比较的元素，同上。
！指针物理意义：v 和 ^ 比较后，将大的元素移动至这里，而后向左移动。


            v     ！
       [3,4,5,0,0,0]                    
                        5 > 3 v-- !--
       [1,2,3]
            ^

          v     ！
       [3,4,5,0,0,5]                    
                        4 > 3 v-- !--
       [1,2,3]
            ^

        v     ！
       [3,4,5,0,4,5]                    
                        3(v) >= 3(^) v-- !--
       [1,2,3]
            ^

      v     ！
       [3,4,5,3,4,5]                    
                        * cornercase: v出界，需要将^所指向的每一个元素拷贝至!指针位置          [1,2,3]                        每拷贝一次，^-- !-- 当^出界后，结束。
            ^

总结需要考虑的问题：
  1. 需要循环(拷贝)的满足条件： ^大于0 也就是说还有元素可以拷贝
  2. cornercase: 
      由于是将nums2合如nums1(如果是nums1大的话（上述例子的返例），也无妨)，所以只需要关注当
      v指针<0后开始特殊拷贝。
  3. 谁大移动谁并拷贝     
 *
 */
var merge = function (nums1, m, nums2, n) {
  let length = m + n; // !指针， v 指针用m，同理^指针用n,不过在移动时候先--再移动。
  while (n > 0) {
    if (m <= 0) {
      // v 指针出界，进行特殊拷贝
      nums1[--length] = nums2[--n];
    }
    // 谁大移动谁，进行比较
    nums1[--length] = nums1[m - 1] >= nums2[n - 1] ? nums1[--m] : nums2[--n];
  }
};
merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3);
```

### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

- 字节跳动|20
- 亚马逊 Amazon|14
- Facebook 脸书|10
- 谷歌 Google|4
- 华为|4
- 微软 Microsoft|4
- 苹果 Apple|3
- 百度|2
- 拼多多|2
- 腾讯 Tencent|2

```js
/**
 * @param {number[]} height
 * @return {number}
 */

/**

思维路径：
  1. 目标求得容纳最多的水，那么不能对数组进行排序操作。
  2. 水的体积？ 可以抽象成成 x轴 * y轴（低的那根）
  3. 什么时候可能是最大的？由于x轴刻度是已知的，所以可以从最大的（两个端点开始查找）


关键点：确立两根指针的位置 -> x[0]  x[length - 1];


解题步骤：
  1. 计算当前两根指针和x围的水
  2. 和已经计算过的最大值取max 并已知的最大值
  3. 两根指针的高度，谁矮移动谁，
  4. 重复上述过程，两根指针“相向而行”，直到两根指针"错位" 结束循环
  5. 返回最大值
    
 */
var maxArea = function(height) {
  let lowerBaff = 0,
      higherBaff = height.length - 1,
      maxArea = -1; // 初始化的已知最大值
  // debug 条件
  while(lowerBaff <= higherBaff) {
      let curArea = Math.abs(lowerBaff - higherBaff) * Math.min(height[lowerBaff],height[higherBaff]);// get CurArea
      maxArea = Math.max(curArea,maxArea); //update maxArea 
      if(height[lowerBaff] > height[higherBaff]) {
        higherBaff--
      }else {
        lowerBaff++
      }
  }
  return maxArea;
};
```

### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)

- 字节跳动|42
- 亚马逊 Amazon|35
- Facebook 脸书|21
- 谷歌 Google|14
- 华为|11
- 微软 Microsoft|9
- 苹果 Apple|8
- 腾讯 Tencent|7
- 爱奇艺|5
- 拼多多|4

```js
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
/**
 * 思维路径：
 *  1. a + b + c = 0 可以转化成 a + b = -c ,也就是求一个两数之和 = target
 *  2. -c 从哪里来？可以遍历每个item，每个都充当一次c => 第一层循环：固定c
 *  3. a 和 b 如何找相加等于-c?  会发现和-c很麻烦，因为c 现在已知，依然可以找 a + b + c = 0的关系
 *      - a + b + c > 0 如何移动？
 *      - a + b + c < 0 如何移动？
 *  4. 因为数据集是无序的，所以上述逻辑关系没有办法产生移动 a 或移动b 指针的行为，因此：
 *      - 将数组进行排序，那么a 指针指向固定元素的下一位
 *      - b指针指向数组的尾部，如下所示：
 * 
 *          a
 *    -4 || -1 -1 0 1 2
 *                    b
 * 
 *  5. 补充第三步：
 *       - 当a + b + c > 0 时，需要将b 往小（--）走，这样才能保证更接近结果。  
 *       - 当a + b + c < 0 时，需要将a 往大 (++)走，这样才能保证更接近结果。  
 *       - 当 ~~~ = 0 时，加入结果中。 各相向走一步
 * 
 *  6. 当a 和 b 指针"错位"后，结束本轮查找，将所固定的元素向前走一步。
 * 
 *  7. 重复上述过程，直到a 指针越界。
 * 
 *  会有什么问题？ !!重复元素!!
 * 
 * 关键点：去重方式和时机

 *  - 如果nums[c] === nums[c - 1] 说明有重复，直接continue 挡板行前走，直到不重复。[时机:c已经改变，并要进行下一轮查找]
 *    （之所以向后比较而不是向前比较，是为了当i到最后一个元素时，不越界）
 *  - 如果nums[a] === nums[a + 1] 说明有重复，直接continue [时机:加入到结果后，要过滤掉后面相邻的相同元素]
 *     (之所以向前比较，是因为极限情况只会发生"错位"，不会发生越界，并且a移动方向就是向前(++))
 *  - 如果nums[b] === nums[b - 1] 说明有重复，直接continue [时机:加入到结果后，要过滤掉后面相邻的相同元素]
 *     (之所以向后比较，是因为如果b就在屁股时，不会发生越界，并且b移动方向就是向后（--）)
 * 
 * 
 * 整体时间复杂度：O(n * n => n * 2)
 */
var threeSum = function(nums) {
  // 边界处理：nums.length < 3时候 或者 nums不存在时候 不需要进行，返回 ;
  if(nums === null || nums.length < 3) {
    return [];
  }
  let res = [];  
  nums.sort((a,b) => a - b);
  for(let i = 0;i < nums.length;i++ ) { // i 上述c 指针
    let L = i + 1, // L 上述a 指针
        R = nums.length -1, // R 上述b 指针
        sum = -1;    
    if( i > 0 && nums[i] === nums[i - 1]) continue; //c 去重时机
    while(L < R) {
      sum = nums[i] + nums[L] + nums[R];
      if(sum === 0) {        
      res.push([nums[i],nums[L],nums[R]]);      
      while(nums[L] === nums[L + 1]) L++; //a 去重时机
      while(nums[R] === nums[R - 1]) R--; //b 去重时机
      L++; 
      R--;
      }else if (sum < 0){        
        L++
      }else {        
        R--
      }      
    }
  }  
  return res;
};
```

### [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)

TODO: 补图

- 微软 Microsoft|19
- 字节跳动|19
- 亚马逊 Amazon|13
- Facebook 脸书|8
- 苹果 Apple|5
- PayPal|5
- 华为|4
- 滴滴打车|4
- eBay|3
- 猿辅导|2

```js
var spiralOrder = function(matrix) {
  if(matrix.length <= 0 || matrix === null) return [];
  let res = [];
  let top = 0,
      left = 0,
      right = matrix[0].length - 1,
      bottom = matrix.length - 1;
  while(top <= bottom && left <= right) {
    for(let i = left;i <= right;i++) {
      res.push(matrix[top][i]);
    }
    top++
    for(let i = top;i <= bottom;i++) {
      res.push(matrix[i][right]);
    }
    right--    
    if(left > right || top > bottom) break;    
    for(let i = right;i >= left;i--) {
      res.push(matrix[bottom][i]);
    }
    bottom--
    
    for(let i = bottom;i >= top;i--) {
      res.push(matrix[i][left]);
    }
    left++
    
  }
  return res;
};
```
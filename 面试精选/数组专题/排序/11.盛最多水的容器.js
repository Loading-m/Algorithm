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
var maxArea = function (height) {
  let lowerBaff = 0,
    higherBaff = height.length - 1,
    maxArea = -1; // 初始化的已知最大值
  // debug 条件
  while (lowerBaff <= higherBaff) {
    let curArea =
      Math.abs(lowerBaff - higherBaff) *
      Math.min(height[lowerBaff], height[higherBaff]); // get CurArea
    maxArea = Math.max(curArea, maxArea); //update maxArea
    if (height[lowerBaff] > height[higherBaff]) {
      higherBaff--;
    } else {
      lowerBaff++;
    }
  }
  return maxArea;
};

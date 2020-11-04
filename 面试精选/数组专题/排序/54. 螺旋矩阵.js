var spiralOrder = function (matrix) {
  if (matrix.length <= 0 || matrix === null) return [];
  let res = [];
  let top = 0,
    left = 0,
    right = matrix[0].length - 1,
    bottom = matrix.length - 1;
  while (top <= bottom && left <= right) {
    for (let i = left; i <= right; i++) {
      res.push(matrix[top][i]);
    }
    top++;
    for (let i = top; i <= bottom; i++) {
      res.push(matrix[i][right]);
    }
    right--;
    if (left > right || top > bottom) break;
    for (let i = right; i >= left; i--) {
      res.push(matrix[bottom][i]);
    }
    bottom--;

    for (let i = bottom; i >= top; i--) {
      res.push(matrix[i][left]);
    }
    left++;
  }
  return res;
};

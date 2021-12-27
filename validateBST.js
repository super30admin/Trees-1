// Time Complexity : O(n)
// Space Complexity : O(n) || O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// optimized approach 1
// We only rely on the stack as extra space, instead of the additional array to run a loop on.
var isValidBST = function (root) {
  if (root === null) return true;
  const stack = [];
  let prev = null;

  while (root !== null || stack.length) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    if (prev !== null && prev.val >= root.val) {
      return false;
    }
    prev = root;
    root = root.right;
  }

  return true;
};

// Optimized approach

// Additional extra space approach. Not most optimal Space Complexity.
// Also uses an extra loop, which while is dropped in asymptotic complexity
// still is a slower tc than other solutions.
var isValidBST = function (root) {
  if (root === null) return true;
  const stack = [];
  const ascArr = []; // will hold root vals in asc order

  while (root !== null || stack.length) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    ascArr.push(root.val);
    root = root.right;
  }

  for (let i = 1; i < ascArr.length; i++) {
    if (ascArr[i] <= ascArr[i - 1]) {
      // must ensure the values are not equal. If equal, return false
      return false;
    }
  }
  return true;
};

[100, 50, 150, 20, 60, 120, 160, 15, 25, 55, 70, null, null, 159, 161];

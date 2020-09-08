//https://leetcode.com/problems/validate-binary-search-tree/
//// Time Complexity : O(n)
//// Space Complexity : O(n) for the stack
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// conceptual, traversing a tree iteratively vs recursive seems easier

//// Your code here along with comments explaining your approach

// Do an inorder tree traversal
// Keep a previous node to check at each node whether prev < current
// return false immediately if prev >= current
// otherwise continue inorder
var isValidBST, node;

isValidBST = function(root) {
  var prev, stack;
  if (root === null) {
    return null;
  }
  prev = null;
  stack = [];
  while (stack.length !== 0 || root !== null) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    if (prev !== null && root.val <= prev.val) {
      return false;
    }
    prev = root;
    root = root.right;
  }
  return true;
};

node = function(value, left = null, right = null) {
  return Object.assign(Object.create(node.prototype), {
    value: value,
    left: left,
    right: right
  });
};

//  5
// / \
// 3  7
isValidBST(node(5, node(3), node(7))); // should be true


//  5
// / \
// 6  7
isValidBST(node(5, node(6), node(7))); // should be false


//  5
// / \
// 3  4
isValidBST(node(5, node(3), node(4))); // should be false


//  5

// / \

// 1 4

//   / \

//   3   6
isValidBST(node(5, node(1), node(4, node(3), node(6)))); // should be false

//# sourceMappingURL=problem1_determine_valid_bst.js.map

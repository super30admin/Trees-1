//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//// Time Complexity : O(n) we visit each node
//// Space Complexity : O(1) just the space for the output tree
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// constructing preorder makes sense, but using that to construct inorder was hard to understand

//// Your code here along with comments explaining your approach
// the root element will be at preorder[0]
// the left tree will be at inorder[0..(index of root element exclusive)]
// the right tree will be at inorder[(index of root element exclusive)..end]
// recursively call to build the left and right
var TreeNode, buildTree;

TreeNode = function(val, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: (val === void 0 ? 0 : val),
    left: left,
    right: right
  });
};

buildTree = function(preorder, inorder) {
  var inorderLeft, inorderRight, preorderLeft, preorderRight, rootIndex, rootValue;
  if (preorder.length === 0) {
    return null;
  }
  rootValue = preorder[0];
  rootIndex = inorder.indexOf(rootValue);
  inorderLeft = inorder.slice(0, rootIndex);
  inorderRight = inorder.slice(rootIndex + 1);
  preorderLeft = preorder.slice(1, 1 + inorderLeft.length);
  preorderRight = preorder.slice(rootIndex + 1);
  return TreeNode(rootValue, buildTree(preorderLeft, inorderLeft), buildTree(preorderRight, inorderRight));
};

//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//buildTree(preorder, inorder)
// should return
//  3
// / \
//9  20
//   /  \
//  15   7

//# sourceMappingURL=problem2_construct_tree_from_inorder_preorder.js.map

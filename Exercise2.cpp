// Problem - Validate BST
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We start our recursion with min and max starting as nullptr
// 2. If we go left, we keep the min same, and max update to root and if we go
// right we keep max same and update min to root
// 3. At any point, if we find min >= root->val and max <= root->val basically
// checking inorder of the tree, then we return false

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {
public:
  bool isValidBST(TreeNode *root) { return helper(root, nullptr, nullptr); }

  bool helper(TreeNode *root, int *min, int *max) {
    if (!root)
      return true;
    if ((min != nullptr && *min >= root->val) ||
        (max != nullptr && *max <= root->val)) {
      return false;
    }
    return helper(root->left, min, new int(root->val)) &&
           helper(root->right, new int(root->val), max);
  }
};

// Problem - Given preorder and inorder traversal of a tree, construct the
// binary tree.
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Create a lookup for inorder array so we can get the start and end points
// easily
// 2. We keep a global idx for preorder, since every idx gives us the next root
// 3. For that node's left we go from start, inorderIdx-1 from inorderMap and
// for node's right we from inorderIdx + 1, end

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
  int idx = 0;
  unordered_map<int, int> inorderMap;
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    // preparing an inorder map for O(1) lookup;
    for (int i = 0; i < inorder.size(); i++) {
      inorderMap[inorder[i]] = i;
    }
    return helper(preorder, 0, (int)inorder.size() - 1);
  }

  TreeNode *helper(vector<int> &preorder, int start, int end) {
    if (start > end) {
      return nullptr;
    }
    int rootVal = preorder[idx];
    int inorderIdx = inorderMap[rootVal];
    idx++;
    TreeNode *node = new TreeNode(rootVal);
    node->left = helper(preorder, start, inorderIdx - 1);
    node->right = helper(preorder, inorderIdx + 1, end);
    return node;
  }
};

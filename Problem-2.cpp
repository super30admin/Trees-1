// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion and inorder traversal checking if the curr 
// value is greater than the prev value and moving forward.

// 105. Construct Binary Tree from Preorder and Inorder Traversal

#include <bits/stdc++.h>
using namespace std;

  //Definition for a binary tree node.
  struct TreeNode {
    int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    int idx = 0;
    map<int,int> mp;
    TreeNode* helper(vector<int>& preorder,int start,int end){
        if(start > end) return NULL;
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = mp[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        root->left = helper(preorder,start,rootIdx-1);
        root->right = helper(preorder,rootIdx+1,end);
        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n = inorder.size();
        for(int i=0;i<n;i++){
            mp[inorder[i]] = i;
        }
        return helper(preorder,0,n-1);
    }
};
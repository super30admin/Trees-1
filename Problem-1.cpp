// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion and inorder traversal checking if the curr 
// value is greater than the prev value and moving forward.

#include <bits/stdc++.h>
using namespace std;

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
    bool flag;
    TreeNode* prev; 
    void inorder(TreeNode* root){
        if(root == NULL) return;
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            flag = false;
        }
        prev = root;
        inorder(root->right);
    }
    bool isValidBST(TreeNode* root) {
        flag = true;
        inorder(root);
        return flag;
    }
};
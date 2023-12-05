/*
Recursively check if each node's value is within the valid range (exclusive) based on its position in the BST.
Update the range for each node during traversal, ensuring that left children have a range of (min, node->val) and right children have a range of (node->val, max).
Return true if the BST conditions are satisfied for all nodes; otherwise, return false.
Time Complexity: O(N), where N is the number of nodes in the tree. The algorithm visits each node once.
Space Complexity: O(H), where H is the height of the tree. The space complexity is determined by the recursive call stack, which is at most the height of the tree for a balanced BST.*/
#include<bits/stdc++.h>
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
       return fun(root, LONG_MAX, LONG_MIN);
    }
    bool fun(TreeNode* root, long long max, long long min){
        if(root==NULL){
            return true;
        }
        if(root->val <=min || root->val>=max){
            return false;
        }
        return fun(root->left, root->val, min) && fun(root->right, max, root->val);
    }
};

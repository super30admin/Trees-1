// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

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
    bool helper(TreeNode* root, TreeNode* low, TreeNode* high) {
        if (root == NULL) return true;
        if ((low!=nullptr && low->val >= root->val) || (high!=nullptr && root->val >= high->val)) return false;
        return helper(root->left, low, root) && helper(root->right, root, high);

    }
    bool isValidBST(TreeNode* root) {
        return helper(root, nullptr, nullptr);
    }
};
// Time Complexity : O(N)
// Space Complexity : O(log(N))
// Passed Leetcode

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
        
        
        if (root) {
            
            if (root->left == nullptr && root->right == nullptr)
                return true;
            long long min = LLONG_MIN;
            long long  max = LLONG_MAX;
            
            return validate(root, min, max);
        } 
        
        return false;
    }
    
    bool validate(TreeNode* root, long long min, long long max) {
        
        if (root == nullptr) {
            return true;
        }
        
        if (root->val <= min || root->val >= max) {
            return false;
        }
        
        if (!validate(root->right, root->val, max) || !validate(root->left, min, root->val))
            return false;
        return true;
        
    }
};
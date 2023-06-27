// Time Complexity: O(n)
// Space Complexity: Recursive Stack Space



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
        return validSubTree(root, LLONG_MIN, LLONG_MAX);
    }

    bool validSubTree(TreeNode* node, long long low, long long high) {
        if(node == nullptr) return true; 
        if(node->val <= low || node->val >= high) return false; 

        return validSubTree(node->left, low, node->val) && validSubTree(node->right, node->val, high);
    }
};
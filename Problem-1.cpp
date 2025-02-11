// https://leetcode.com/problems/validate-binary-search-tree/description/
// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively check if the root value is greater than the min and lesser than the max value.

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
        bool isBST(TreeNode* root, long minVal, long maxVal){
            if(root == NULL) return true;
            if(root->val <= minVal || root->val >= maxVal) return false;
            return (isBST(root->left, minVal, root->val) && isBST(root->right, root->val, maxVal));
        }
        bool isValidBST(TreeNode* root) {
            return isBST(root, LONG_MIN, LONG_MAX);
        }
    };
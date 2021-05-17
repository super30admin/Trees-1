// Time Complexity :O(n) where n in the number of nodes
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
        return solveBST(root,-INFINITY,INFINITY);
    }
    bool solveBST(TreeNode* root, double min,double max){
        if(root == nullptr) return true;
        if(root->val < min || root->val > max || root->val == min || root->val == max)
            return false;
        return solveBST(root->left,min,root->val) && solveBST(root->right,root->val,max);
    }
};
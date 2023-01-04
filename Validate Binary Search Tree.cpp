// TC = O(N)
// SC = O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
 
    bool flag;
    TreeNode *prev;
    bool isValidBST(TreeNode* root) {
        flag = true;
        inorder(root);
        return flag;
    }
    void inorder(TreeNode *root) {
        // base
        if(root == NULL) return;
        inorder(root->left);
        // checking for increasing order in inorder to validate BST
        if(prev != NULL && prev->val >= root->val) flag = false;
        // reassigning prev to root for the right call
        prev = root;
        // optimization - right call only when the left ones are valid
        if(flag) inorder(root->right);
    }
};
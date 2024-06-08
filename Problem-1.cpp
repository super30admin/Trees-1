// Time Complexity : O(n) as we are only doing inorder traversal over tree and traversing n nodes in tree
// Space Complexity : O(1) as no new space is used excpet prev value
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

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
    bool isValid;
    TreeNode* prev;
public:
    bool isValidBST(TreeNode* root) {
        isValid = true;
        prev = NULL;
        inorder(root);
        return isValid;
    }
    void inorder(TreeNode* root)
    {
        if(root == NULL)
            return;
        inorder(root->left);
        if(prev!=NULL && root->val <= prev->val)
        {
            isValid = false;
        }
        prev = root;
        inorder(root->right);
        return;
    }
    
};
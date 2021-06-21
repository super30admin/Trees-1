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
        
        return dfs(root,NULL,NULL);
    }
    bool dfs(TreeNode* root, TreeNode* low, TreeNode* high)
    {
        if(root==nullptr)
            return true;
        if((low!=nullptr and root->val<=low->val) or (high!=nullptr and root->val>=high->val))
        {
            return false;
        }
        bool l=dfs(root->left,low,root);
        bool r=dfs(root->right,root,high);
        return (l and r);
    }
};

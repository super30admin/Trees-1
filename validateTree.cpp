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
        return helper(root,NULL,NULL);
    }
    bool helper (TreeNode* node, TreeNode *min, TreeNode *max) {
        
        if(node==NULL) return true;
        
        int value=node->val;
        if (min!=NULL && value<=min->val) return false;
        if (max!=NULL && value>=max->val) return false;
        
        return helper(node->left,min,node) && helper(node->right,node,max);
    }
};
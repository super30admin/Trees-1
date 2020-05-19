//Time Complexity-O(n)
//Space Complexity-O(n)
//Ran successfully on leetcode

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
/*Iterative solution with stack
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*>s;
        TreeNode* prev=NULL;
        while(root!=NULL || !s.empty())
        {
            while(root!=NULL)
            {
                s.push(root);
                root=root->left;
            }
            root=s.top();
            s.pop();
            if(prev!=NULL && (prev->val>=root->val))
                return false;
            prev=root;
            root=root->right;
        }
        return true;
    }
};*/
//Recursive solution
class Solution {
    TreeNode*prev=NULL;
public:
    bool isValidBST(TreeNode* root) {
        return helper(root);
    }
    bool helper(TreeNode*root)
    {
        if(root==NULL)
            return true;
        if(helper(root->left)==false)
            return false;
        if(prev!=NULL && (prev->val>=root->val))
            return false;
        prev=root;
        if(helper(root->right)==false)
            return false;
        else
            return true;
    }
};
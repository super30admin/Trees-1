/*
TC: O(n)
SC: O(n)

 */
class Solution {
public:
bool valid=true;
TreeNode* prev;
    bool isValidBST(TreeNode* root) {
        if(root==nullptr)
            return true;  
        //prev=root; 
         dfs(root);
         return valid;
    }
    void dfs(TreeNode* root)
    {
        if(root==nullptr)
            return; 
        dfs(root->left);
        if(prev!=nullptr and prev->val>=root->val)
        {
            valid=false;
            return;
        }
        prev=root;
        dfs(root->right);
     
    }
};
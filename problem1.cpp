//Time Complexity - O(n)
//Space Complexity - O(HeightOfTree)
class Solution {
public:
    bool helper(TreeNode* root, TreeNode* &prev){
        if(!root)
            return true;
        if(!helper(root->left,prev))
            return false;
        if(prev&&root->val<=prev->val)
            return false;
        prev = root;
        return helper(root->right,prev);
    }
    bool isValidBST(TreeNode* root) {
        TreeNode* prev=NULL;
        return helper(root,prev);
    }
};
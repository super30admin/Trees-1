// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    bool helper(TreeNode* root, TreeNode** prev){
        if(root==NULL) return true;
        bool l = helper(root->left, prev);
        if(l==false) return false;
        if(*prev!=NULL && (*prev)->val>=root->val) return false;
        *prev=root;
        return helper(root->right, prev);
    }
    
    bool isValidBST(TreeNode* root) {
        TreeNode *prev;
        prev=NULL;
        return helper(root, &prev);
    }
};

//Time Complexity- O(n)
//Space Complexity- O(1)

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        if(isBST(root,LONG_MIN,LONG_MAX)){
            return true;
        }
        
        return false;
    }
    
    bool isBST(TreeNode* root,long min,long max){
        
        if(root==NULL){
            return true;
        }
        
        if(root->val<=min || root->val>=max){
            return false;
        }
        
        return (isBST(root->left,min,root->val) && isBST(root->right,root->val,max));
    }
};
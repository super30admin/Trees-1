class Solution {
    // TC O(n)
    // SC O(h)// height of tree in worst case can be n 
public:
    bool isValidBST(TreeNode* root) {
        return checkIfBST(root, LONG_MIN,LONG_MAX);
    }
    bool checkIfBST(TreeNode* root, long min,long max){
        if(root == NULL) return true;
        if(root->val>=max || root->val <= min) return false;
        return checkIfBST(root->left,min,root->val) && checkIfBST(root->right, root->val, max);
    }

};
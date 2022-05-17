// Time Complexity : o(n)
// Space Complexity : o(n)
// Where n = number of elements in the list given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    bool checkBST(TreeNode* root, long minVal, long maxVal) {
        if(root==NULL)return true;
        if(root->val < maxVal && root->val > minVal && checkBST(root->left,minVal,root->val) && checkBST(root->right,root->val, maxVal)) {
            return true;
        }
        return false;
    }
    bool isValidBST(TreeNode* root) {
        return checkBST(root, LONG_MIN, LONG_MAX);
    }
};
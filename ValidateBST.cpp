// Time Complexity : O(N) where N is the number of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
// Submission Link: https://leetcode.com/submissions/detail/537091675/

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return isValid(root, LONG_MIN, LONG_MAX);
    }
    
    bool isValid(TreeNode* root, long min_val, long max_val){
        if(root == NULL)
            return true;
        
        if(root -> val <= min_val || root -> val >= max_val)
            return false;
        
        return isValid(root -> left, min_val, root -> val) && 
               isValid(root -> right, root -> val, max_val);
    }
};
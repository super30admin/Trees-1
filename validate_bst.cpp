// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    bool valid_bst_rec(TreeNode* root, long long min_val, long long max_val)
    {
        if(root == NULL)
            return true;

        // Check if val in proper range        
        if((long long)root->val <= min_val || (long long)root->val >= max_val)
            return false;
        
        bool res1, res2;
        
        // Ensure the subtrees are also valid
        res1 = valid_bst_rec(root->left, min_val, root->val);
        
        res2 = valid_bst_rec(root->right, root->val, max_val);
        
        return (res1 && res2);
    }
    
    bool isValidBST(TreeNode* root) {
        
        bool res = valid_bst_rec(root, LLONG_MIN, LLONG_MAX);      
        
        return res;
    }
};
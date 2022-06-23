
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



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
    
    bool isValidBSTrecur( TreeNode* root, double min, double max ){
        if( root == nullptr ){
            return true;
        }
        if( root->val <= min || root->val >= max){
            return false;
        }  
        return ( isValidBSTrecur( root->right, root->val, max ) && isValidBSTrecur( root->left, min, root->val ) );
        
    }
    
    
    bool isValidBST(TreeNode* root) {
        
        if( root == nullptr || ( root->left == nullptr && root->right == nullptr ) ){
            return true;
        }
        
        double min = LLONG_MIN;
        double max = LLONG_MAX;
        
        return isValidBSTrecur( root, min, max );
        
        
    }
};

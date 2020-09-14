// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
    bool isValidBST(TreeNode* root) {
        TreeNode* prev = NULL;
    
        
        if ( root == NULL)
            return true;
        
        stack <TreeNode* > mystack;
        while (!mystack.empty() || root != NULL){
            while (root != NULL){
                mystack.push(root);
                root = root->left;
            }
            
            root = mystack.top();
            if(prev!= NULL && prev->val >= root->val)
                return false;
            
            mystack.pop();
            prev = root;
            root = root->right;

        }
        return true;
    }
    
};
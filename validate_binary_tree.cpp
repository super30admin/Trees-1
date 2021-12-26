//Time complexity : O(n)
//Space complexity : O(h)

//Leetcode : Yes
// Approach:
            // Keep traversing in order
            // Check every previous node value with current value
            // Set isValid to false if previous is greater than current as we are traversing inOrder

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
    bool isValid;
    TreeNode* prev = nullptr;
    bool isValidBST(TreeNode* root) {
        if(root == nullptr)
            return true;
        
        isValid = true;
        validate(root);
        return isValid;
    }
    
    void validate(TreeNode* root)
    {
        if(root == nullptr)
            return;
        
        //Logic
        validate(root->left);
        
        if(prev != nullptr && prev->val >= root->val)
        {
            isValid = false;
            return;
        }
        prev = root;
        
        validate(root->right);
    }
};
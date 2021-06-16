/*
Intuition: Use inorder traversal. Use a prev pointer and check if its value is always <= current pointer.
//////////////////////////////////////////
Time Complexity: O(N), N = Total number of elements
//////////////////////////////////////////
Space Complexity: O(H), H = Height of the tree
*/

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
    bool isValid = true;
    TreeNode* prev = NULL;
    bool isValidBST(TreeNode* root) {
        helper(root);
        return isValid;
    }
    
    void helper(TreeNode* root){
    
        if (root == NULL){
            return;
        }

        helper(root->left);
        if (prev != NULL and prev->val >= root->val){
            isValid = false;
            return;
        }
        prev = root;
        helper(root->right);
        return;
    }
};


//Using Bool return type
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
    TreeNode* prev = NULL;
    bool isValidBST(TreeNode* root) {
        return helper(root);
    }
    
    bool helper(TreeNode* root){
    
        if (root == NULL){
            return true;
        }

        if (helper(root->left) == false){
            return false;
        } 
        if (prev != NULL and prev->val >= root->val){
            return false;
        }
        prev = root;
        return helper(root->right);
    }
};
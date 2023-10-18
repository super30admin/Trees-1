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
    TreeNode *prev;// main concept of global and local variables, example what I should provide to the interviewer if asked for an example of these.
public:
    bool isValidBST(TreeNode* root) {
        return inorder(root);       
    }

    bool inorder(TreeNode* root){
        if(root == NULL) return true;
        //bool left = inorder(root->left);
        if(!inorder(root->left)) return false;
        if(prev!= NULL && prev->val>=root->val)return false;
        prev = root;
        //bool right = inorder(root->right);
        return inorder(root->right);

    }
};

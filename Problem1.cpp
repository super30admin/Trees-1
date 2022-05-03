//Time complexity: O(H).

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
    bool isValid =  true;
    bool isValidBST(TreeNode* root) {
     
         inorder(root); 
        return isValid;
    }
    
   void inorder(TreeNode* root) {
        
       if(root == NULL) return ;
           
       inorder(root->left);
       if(prev != NULL && prev->val >= root->val){
           isValid = false;
           return ;
       }
       prev =  root;
       inorder(root->right);
    }
};
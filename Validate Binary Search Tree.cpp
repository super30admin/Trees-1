// time: O(n)
// space: O(log n) recursive space

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
    bool flag = true;
    TreeNode* prev = NULL;
    void inorder (TreeNode* root) {
        
        if(flag == false || root == NULL) {
            return;
        }
        
        inorder(root -> left);
        
        if(prev != NULL && root -> val <= prev -> val) {
            flag = false;
            return;
        }
        prev = root;
        inorder(root -> right);
        
    }
public:
    bool isValidBST(TreeNode* root) {
        inorder(root);
        return flag;
    }
};
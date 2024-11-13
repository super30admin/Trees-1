//there are three ways to traverse through the tree
// inorder, preorder,postorder
// if we traverse through the tree in in order it will be traversed in sorted ascending order
// we can traverse that keep track of the previous the value in the stack and compare if 
// the curr value is greater than prev and there is no breach till end then the tree is valid


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
    // long long int prev = LLONG_MIN;
    // bool flag = true;
private:
    bool helper(TreeNode *root,long long int prev)
    {
        //Base case
        if(root == NULL)
            return true;
        
        // traverse
        bool left = helper(root->left,prev);
        if(root->val <= prev)
            return false;
        prev = root->val;
        
        bool right = helper(root->right,prev);

        
        return left && right;
    }
public:
    bool isValidBST(TreeNode* root) {
        long long int prev = LLONG_MIN;
        return helper(root,prev);
    }
};
//Time complexity O(N)
//space complexity O(H) h = depth of the tree ,in balanced BST it will be log H
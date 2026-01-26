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
        return helper(root, nullptr, nullptr);
    }

    bool helper(TreeNode* root, TreeNode* min, TreeNode* max) {
        // termination condition
        if (root == nullptr)
            return true;

        // logic
        if (min != nullptr && root->val <= min->val) return false;
        if (max != nullptr && root->val >= max->val) return false; 


        //branching in the tree
        return helper(root->left, min, root) && helper(root->right, root, max);

    }
};

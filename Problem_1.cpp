/*
 ? Problem: Validate Binary Search Tree
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return dfs(root, nullptr, nullptr);
    }

    // Inorder traversal should be correct if the Binary Search Tree is valid
    bool dfs(TreeNode* node, int* left, int* right) {
        if (node == nullptr) return true;

        if (left && node->val <= *left) return false;
        if (right && node->val >= *right) return false;

        return dfs(node->left, left, &node->val) && dfs(node->right, &node->val, right);
    }
};
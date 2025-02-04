// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 98: Validate Binary Search Tree
// Approach: DFS
// Time Complexity: O(n)
// Space Complexity: O(h)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution
{
public:
    bool isValidBST(TreeNode *root)
    {
        // Base Case
        if (!root)
        {
            return true;
        }

        return dfs(root, NULL, NULL);
    }

    bool dfs(TreeNode *root, TreeNode *min, TreeNode *max)
    {
        // Base Case
        if (root == NULL)
        {
            return true;
        }

        // Condition to check if does not satisfy BST, if not return false
        if ((min != NULL && root->val <= min->val) ||
            (max != NULL && root->val >= max->val))
        {

            return false;
        }

        return dfs(root->left, min, root) && dfs(root->right, root, max);
    }
};
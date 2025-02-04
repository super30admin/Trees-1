// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 105: Construct binary tree from preorder and inorder traversal
// Approach: Using Preorder and Postorder
// Time Complexity: O(n)
// Space Complexity: O(n)

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
    int idx = 0;                         // Tracks the current index in the preorder traversal.
    unordered_map<int, int> inorderHash; // Maps each value in the inorder traversal to its index for O(1) lookup

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {

        // Base Case
        if (preorder.empty() || inorder.empty())
        {
            return NULL;
        }

        // Populate the hash map with the elements and index in the inorder
        for (int i = 0; i < inorder.size(); i++)
        {
            inorderHash[inorder[i]] = i;
        }

        return getTree(preorder, 0, preorder.size() - 1);
    }

    TreeNode *getTree(vector<int> &preorder, int start, int end)
    {

        // Base Case
        if (start > end)
        {
            return NULL;
        }

        // Get the current root value from the preorder traversal.
        int rootVal = preorder[idx];

        // Move to the next index in preorder.
        idx++;

        // Find the index of the root value in the inorder traversal.
        int rootIdx = inorderHash[rootVal];

        // Create a new tree node for the root.
        TreeNode *root = new TreeNode(rootVal);

        // Recursively build the left and right subtrees.
        root->left = getTree(preorder, start, rootIdx - 1);
        root->right = getTree(preorder, rootIdx + 1, end);

        return root; // Return the constructed tree.
    }
};
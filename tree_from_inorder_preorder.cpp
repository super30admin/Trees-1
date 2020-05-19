//Time Complexity-O(n)
//Space Complexity-O(n)
//Ran successfully on leetcode

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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.size() == 0) 
            return NULL;
        return buildTree(preorder, inorder, 0, 0, inorder.size() - 1);
    }
    
    TreeNode* buildTree(vector<int>&preorder, vector<int>&inorder, int preorderIndex, int start, int end) 
    {
        if (start > end) return NULL;
        TreeNode*node = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = findInorderIndex(inorder, start, end, preorder[preorderIndex]);
        int leftTreeSize = inorderIndex - start;
        int rightTreeSize = end - inorderIndex;
        node->left = buildTree(preorder, inorder, preorderIndex + 1, start, inorderIndex - 1);
        node->right = buildTree(preorder, inorder, preorderIndex + leftTreeSize + 1, inorderIndex + 1, end);
        return node;
    }
    int findInorderIndex(vector<int>inorder, int start, int end, int key)
    {
        for (int i = start; i <= end; i++)
        {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
};
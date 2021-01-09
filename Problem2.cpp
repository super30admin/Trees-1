// Time Complexity : O(N)
// Space Complexity : O(log(N))
// Passed Leetcode

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
            return nullptr;
        
        return helper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
        
    }
    
    TreeNode* helper(vector<int>& preorder, int i, int j, vector<int>& inorder, int i1, int j1) {
        if (i > j) {
            return nullptr;
        }
        
        TreeNode* node = new TreeNode(preorder.at(i));
        // node->val = preorder.at(i);
        int rootIndex = -1;
        for (int k = i1; k <= j1; k++) {
            if (preorder.at(i) == inorder.at(k)) {
                rootIndex = k;
                break;
            }
        }
        
        node->left = helper(preorder, i + 1, rootIndex - i1 + i, inorder, i1, rootIndex);
        node->right = helper(preorder, rootIndex - i1 + i + 1, j, inorder, rootIndex + 1, j1);
        return node;
        
        
    }
};
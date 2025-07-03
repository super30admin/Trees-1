// Time Complexity O(n)
// Space complexitty O(h)

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

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder,  unordered_map<int, int>& store, int left, int right) {
        
        if (left > right) {
            return nullptr;
        }

        TreeNode* node = new TreeNode(preorder[preorderIdx]);
        int inorder_index = store[preorder[preorderIdx]];
        preorderIdx++;

        node->left = buildTree(preorder, inorder, store, left, inorder_index-1);
        node->right = buildTree(preorder, inorder, store, inorder_index+1, right);
        
        return node;
    }

    int preorderIdx = 0;

public:

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {

        if (preorder.empty()) {
            return nullptr;
        }

        unordered_map<int, int> store;
        for (int i = 0; i < inorder.size(); i++) {
            store[inorder[i]] = i;
        }

        return buildTree(preorder, inorder, store, 0, inorder.size()-1);
    }
};
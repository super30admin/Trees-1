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
    unordered_map<int, int> um;
    int preIndex;
    TreeNode* helper(vector<int>& preorder, int left, int right) {
        if (left > right) {
            return nullptr;
        }

        TreeNode *root = new TreeNode(preorder[preIndex]);
        preIndex++;

        int index=um[root->val];

        root->left = helper(preorder, left, index-1);
        root->right = helper(preorder, index+1, right);

        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for (int i=0;i<inorder.size();i++) {
            um[inorder[i]] = i;
        }
        this->preIndex = 0;
        int left = 0;
        int right = preorder.size()-1;
        return helper(preorder, left, right);
    }
};

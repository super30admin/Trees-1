// Time complexity : O(n)
// Space complexity : O(n)

// Approach :
            // First element of preorder will provide us with root
            // Once we have root, search for root in inorder traversal
            // Left side of root will have all the elements in left subtree\
            // Right side will have right subtree
            // Recurse through right and left subtree with the same
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
    map<int,int> inorder_map;
    int idx = 0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0 || preorder.size() != inorder.size())
            return nullptr;
        
        for(int i = 0 ; i < inorder.size(); i++)
        {
            inorder_map[inorder[i]] = i;
        }
        
        return helper(preorder, 0 , preorder.size() - 1);
    }
    
    TreeNode* helper(vector<int> preorder, int start, int end)
    {
        if(start > end)
            return nullptr;
        
        int rootVal = preorder[idx];
        idx++;
        int index = inorder_map[rootVal];
        
        TreeNode* root = new TreeNode(rootVal);
        
        root->left = helper(preorder, start, index - 1);
        root->right = helper(preorder, index + 1, end);
        
        return root;
    }
};
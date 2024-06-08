// Time Complexity : O(n+n) where n is number of nodes in the tree, first n is to create inorder map, second n is to create tree
// Space Complexity : O(n) n space is required for storing elements in map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

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
    unordered_map<int, int> inorder_map;
    int idx;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i=0;i<inorder.size();i++)
            inorder_map.insert(make_pair(inorder[i], i));
        idx=0;
        return recurse(preorder, 0, inorder.size()-1);
    }

    TreeNode* recurse(vector<int> preorder, int start, int end)
    {
        if(start > end)
        {
            return NULL;
        }
            
        int root_val = preorder[idx];
        TreeNode* root = new TreeNode(root_val);
        idx++;
        root->left = recurse(preorder, start, inorder_map[root_val]-1);
        root->right = recurse(preorder, inorder_map[root_val]+1, end);
        return root;
    }
};
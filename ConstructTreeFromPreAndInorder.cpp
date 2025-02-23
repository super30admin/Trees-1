// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

using namespace std;

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
    unordered_map<int, int> mp;
    int pre_ind = 0;
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int i, int j) {
        if (i >j) return nullptr;
        int node = preorder[pre_ind++];
        TreeNode* root = new TreeNode(node);
        
        int idx = mp[node];
        root->left = helper(preorder, inorder, i, idx-1);
        root->right = helper(preorder, inorder,idx+1 , j);
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        
        for (int i=0; i<inorder.size(); i++) {
            mp[inorder[i]] = i;
        }
        return helper(preorder, inorder, 0, inorder.size()-1);
    }
};
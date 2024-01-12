// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is to find the root, which is first element from preorder and find its index from 
// inorder. Then recursively find left and right nodes.

#include<vector>
#include<unordered_map>

/**
 * Definition for a binary tree node.
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
    std::unordered_map<int, int> map;
    int idx;
    TreeNode* buildTree(std::vector<int>& preorder, std::vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++)
        {
            map[inorder[i]] = i;
        }
        return helper(preorder, 0, inorder.size()-1);
    }

    TreeNode* helper(std::vector<int>& preorder, int start, int end)
    {
        //base 
        if(start > end)
        {
            return nullptr;
        }
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        root->left = helper(preorder, start, rootIdx-1);
        root->right = helper(preorder, rootIdx+1, end);
        return root;
    }
};
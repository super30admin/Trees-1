// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(n) - Hashmap is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    unordered_map<int, int> map;
    int index = 0;
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end) {
        //base condition
        if(start > end) return nullptr;
        //if(index == preorder.size()) return nullptr;
        
        // logic
        int rootValue = preorder[index];
        int rootIndex = map[rootValue];
        TreeNode *root = new TreeNode(rootValue);
        index++;
        root->left = helper(preorder, inorder, start, rootIndex-1);
        root->right = helper(preorder, inorder, rootIndex+1, end);
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0 || inorder.size() == 0) return nullptr;
        
        for(int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return helper(preorder, inorder, 0, inorder.size()-1);
    }
    
};

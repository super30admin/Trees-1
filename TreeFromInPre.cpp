// Time Complexity : O(N) where N is the number of elements in the array
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Submission Link: https://leetcode.com/submissions/detail/537349141/

class Solution {
    int idx = 0;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> indices;
        
        for(int i = 0; i < inorder.size(); i++)
            indices[inorder[i]] = i;
        
        return helper(preorder, indices, 0, inorder.size() - 1);
    }
    
    TreeNode* helper(vector<int>& preorder, unordered_map<int, int>& indices, int low, int high){
        if(low > high)
            return NULL;
        
        int val = preorder[idx++];
        TreeNode* root = new TreeNode(val);
        root -> left = helper(preorder, indices, low, indices[val] - 1);
        root -> right = helper(preorder, indices, indices[val] + 1, high);
        
        return root;
    }
};
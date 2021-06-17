// Time Complexity : O(n)
// Space Complexity :  O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve it properly. Took reference from lecture

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        if(preorder.size() == 0)
            return NULL;
        
        int root_val = preorder[0];
        int root_index = 0;
        TreeNode* root = new TreeNode;
        root->val = root_val;

        // Find the index of root element        
        for(int i = 0; i < inorder.size(); i++)
        {
            if(inorder[i] == root->val)
                root_index = i;
        }
        
        vector<int> pre_left;
        vector<int> pre_right;
        vector<int> in_left;
        vector<int> in_right;
        
        // Divide the Trees depending on the root element
        copy(preorder.begin()+1, preorder.begin()+root_index+1, back_inserter(pre_left));
        copy(preorder.begin()+root_index+1, preorder.begin()+preorder.size(), back_inserter(pre_right));
        copy(inorder.begin(), inorder.begin()+root_index, back_inserter(in_left));
        copy(inorder.begin()+root_index+1, inorder.begin()+inorder.size(), back_inserter(in_right));
        
        // Build the subtrees
        root->left = buildTree(pre_left, in_left);
        root->right = buildTree(pre_right, in_right);
        
        return root;
    }
};
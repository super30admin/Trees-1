// 05. Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
first creates a hashmap to store the indices of elements in the inorder traversal for efficient lookup. 
Then, recursively builds the tree by dividing the preorder sequence into left and right subtrees based
on the root index obtained from the inorder sequence.This process continues until the entire tree is constructed, 
with each recursive call handling a subtree.
*/

class Solution {
public:
    int ind = 0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> umap;
        for(int i = 0; i < inorder.size(); i++)
            umap[inorder[i]] = i;
        return helper(preorder, umap, 0, preorder.size()-1);
    }
    TreeNode* helper(vector<int>& preorder,unordered_map<int, int>& umap, int l, int r)
    {
        if(l > r) return NULL;

        TreeNode *root = new TreeNode(preorder[ind]);
        int rootIdx = umap[preorder[ind]];
        ind++;

        root->left = helper(preorder, umap, l, rootIdx-1);
        root->right = helper(preorder, umap, rootIdx+1, r);
        return root;

    }
};
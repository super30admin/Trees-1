// Time Complexity : O(n)
// Space Complexity : O(n) where n tends to h
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Maintain the pointer to point to root value of current subtree.
 * First value in preorder is the root value of tree. 
 * Create a node using that value and increment the pointer to point to next subtree root value. 
 * Find the root value index in the inorder array.
 * Split the inorder array in two parts - (0, root_index_in_inorder - 1 ) and (root_index_in_inorder + 1, n)
 * Keep repeating the above steps until start and end indexes do not cross each other which indicates end of subtree.   
 */

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
    map<int, int> m;
    int idx;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.size() == 0 || inorder.size() == 0)
            return nullptr;
        
        for (int i = 0; i < inorder.size(); i++)
        {
            m.insert({inorder[i], i});
        }
        
        idx = 0;
        return helper(preorder, 0, preorder.size() - 1);
    }
    
    TreeNode* helper(vector<int>& preorder, int start, int end)
    {
        if (start > end)
            return nullptr;
        
        TreeNode* root = new TreeNode(preorder[idx]);
        
        int rootIdx = m.find(preorder[idx])->second;
        
        idx++;
        
        root->left = helper(preorder, start, rootIdx - 1);
        root->right = helper(preorder, rootIdx + 1, end);
        
        return root;
    }
};
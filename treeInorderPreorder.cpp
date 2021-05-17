// Time Complexity :O(n) where n in the number of nodes
// Space Complexity : O(n)  
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int l = 0;
        return helper(l,0,inorder.size()-1,preorder,inorder);
    }
    TreeNode* helper(int &preStart,int inStart,int inEnd,vector<int>& preorder,vector<int>& inorder){
        if(inStart > inEnd || preStart >= preorder.size()) return nullptr;
        TreeNode *root = new TreeNode(preorder[preStart]);
        int inIndex;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == preorder[preStart])
                inIndex =i;
        }
        preStart++;
        root->left =helper(preStart,inStart,inIndex-1,preorder,inorder);
        root->right =helper(preStart,inIndex+1,inEnd,preorder,inorder);
        return root;
    }
};
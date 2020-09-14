// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
        //edge case
        if(preorder.size()==0 || inorder.size()==0){
            return NULL;
        }
        return helper(preorder, 0, inorder, 0, inorder.size()-1);
    }
private:
    TreeNode* helper(vector<int>& preorder,int pre_index, vector<int>&  inorder,int in_start,int in_end){
        //return condition
        if(in_start>in_end){
            return NULL;
        }
        TreeNode* root = new TreeNode (preorder[pre_index]);
        int i;
        for(i=0; i<inorder.size(); i++ ){
            if(inorder[i]==root->val) break;
        }
        root->left = helper(preorder, pre_index+1, inorder, in_start , i-1);
        root->right = helper(preorder, pre_index+i-in_start+1, inorder, i+1, in_end );
        return root;
    }
    
};
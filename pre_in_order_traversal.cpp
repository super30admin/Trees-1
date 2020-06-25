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

//Hashmapsolution
// Time Complexity : O(n)
// Space Complexity : O(n).
//1. Find build hashmap for the inorder traversal array
//2. Find root using hashmap and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part
class Solution {
public:
    unordered_map<int, int> tree_map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //edge case
        if(preorder.size()==0 || inorder.size()==0){
            return NULL;
        }
        for(int i=0; i<inorder.size(); i++){
            tree_map[inorder[i]] = i;
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
        int i= tree_map[root->val];
        root->left = helper(preorder, pre_index+1, inorder, in_start , i-1);
        root->right = helper(preorder, pre_index+i-in_start+1, inorder, i+1, in_end );
        return root;
    }
    
};

//Recursive solution
// Time Complexity : O(n^2)
// Space Complexity : O(n).
//1. Find root and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part
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

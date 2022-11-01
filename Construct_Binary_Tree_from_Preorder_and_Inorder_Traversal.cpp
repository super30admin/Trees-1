/*
Time Complexity: O(n)
Space Complexity: O(h)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
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
    vector<int> preorder, inorder;
    int preorderIndex;
    unordered_map<int,int> inorderList; 
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preorderIndex = 0;
        this->preorder =preorder;
        this->inorder =inorder;
        
        for(int i = 0; i<inorder.size();i++){
            inorderList[inorder[i]]=i;
        }
        return buildTree(0,inorder.size()-1);
    }
    TreeNode* buildTree(int inStart, int inEnd){
        //base
        if(inStart>inEnd)  return NULL;
        //recursive
        TreeNode* node = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        int inorderIndex = getIndex(node->val);
        node->left = buildTree(inStart, inorderIndex-1);
        node->right = buildTree(inorderIndex+1, inEnd);
        
        return node;
    }
    int getIndex(int ele){
        return inorderList[ele];
    }
};
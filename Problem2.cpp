// Time Complexity : O(n) 
// Space Complexity : O(n) system stack in case of recursion
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Construct Binary Tree from Preorder and Inorder Traversal

#include<iostream>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        int preorderLen = preorder.size();
        int inorderLen  = inorder.size();
        
        if (preorderLen <= 0 || inorderLen <= 0)
            return NULL;
        
        if (preorderLen != inorderLen)
            return NULL;
        
        int k;
        for(k=0; preorder[0]!=inorder[k];k++);
        
        TreeNode* newNode = new TreeNode(preorder[0]);
        
        vector<int> tmpPreorder1 (preorder.begin()+1, preorder.begin()+1+k);
        vector<int> tmpInorder1  (inorder.begin(), inorder.begin()+k);
        
        newNode->left  = buildTree(tmpPreorder1, tmpInorder1);
        
        vector<int> tmpPreorder2 (preorder.begin()+1+k, preorder.end());
        vector<int> tmpInorder2  (inorder.begin()+k+1,  inorder.end());
        
        newNode->right = buildTree(tmpPreorder2, tmpInorder2);
        
        return newNode;
        
    }
};
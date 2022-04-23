// Time Complexity                              :  O(N)
// Space Complexity                             :  O(N) if it is a skewed tree with N nodes 
//                                                 else it will be O(h) where h is maximum height of the tree.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/

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
private:
    int preInd = 0;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        return bTree(preorder,inorder,0,inorder.size()-1);
    }
    
    // builds the tree 
    TreeNode* bTree(vector<int>& preorder, vector<int>& inorder,int start, int end) {
        if(end < start) return NULL;
        
        TreeNode *node = new TreeNode(preorder[preInd++]);
        int pos;
        
        for(int i=start;i<=end;i++) {
            if(node->val == inorder[i]) {
                pos = i;
                break;
            }
        }
        
        // divides the inorder array into left and right array based on the value of pos above.
        node->left = bTree(preorder, inorder, start, pos-1);
        node->right = bTree(preorder, inorder, pos+1, end);
        return node;
    }
};
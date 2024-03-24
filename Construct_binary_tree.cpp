// Time Complexity : O(n) ...... N is total number of elements in tree
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Given two integer arrays preorder and inorder where preorder is the preorder traversal of 
a binary tree and inorder is the inorder traversal of the same tree, 
construct and return the binary tree.
*/

/*
Explaination :  watch for understanding - https://www.youtube.com/watch?v=AnzeyrnWCeY
*/


class Solution {
    int idx = 0;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0) return nullptr;
        unordered_map<int, int> hMap;
        for(int i = 0; i<inorder.size(); i++){
            hMap[inorder[i]] = i;
        }

        return helper(hMap, 0, inorder.size()-1, preorder);
    }

    TreeNode* helper (unordered_map<int, int> &hMap, int start, int end,
                       vector<int>& preorder){

        if (start > end) return nullptr;

        int rootVal = preorder[idx];
        idx++;
        int rootIdx = hMap[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        root->left = helper(hMap, start, rootIdx-1, preorder);
        root->right = helper(hMap, rootIdx+1, end, preorder);

        return root;

    }
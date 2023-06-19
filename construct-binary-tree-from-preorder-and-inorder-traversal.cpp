// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

//Implementing a tree class
class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

//using preorder we find the root and then find root in inorder and find the left sub tree and right subtree
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //base
        if(preorder.size() == 0) return NULL;
        //logic
        int rootVal = preorder[0];
        TreeNode* root = new TreeNode(rootVal);
        int rootIdx = -1;
        for(int i = 0; i < inorder.size(); i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        vector<int> inLeft(inorder.begin(), inorder.begin() + rootIdx);
        vector<int> inRight(inorder.begin() + rootIdx + 1, inorder.end());
        vector<int> preLeft(preorder.begin() + 1, preorder.begin() + 1 + inLeft.size());
        vector<int> preRight(preorder.begin() + 1 + inLeft.size(), preorder.end());

        root->left = buildTree(preLeft, inLeft);
        root->right = buildTree(preRight, inRight);

        return root;
    }
};
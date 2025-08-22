#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
We use preorder to get the root and a map to find its position in the inorder array.
Everything before that index in inorder goes to the left subtree, rest to the right.
We recurse left first (because preorder is root-left-right), then build the right subtree.
*/
class Solution{
public:
    int idx = 0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> map;
        for (int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return helper(preorder, 0, preorder.size() - 1, map);
    }
private:
    TreeNode* helper(vector<int>& preorder, int start, int end, unordered_map<int, int>& map) {
        if (start > end) return nullptr;

        int rootVal = preorder[idx++];
        int rootIdx = map[rootVal];
        TreeNode* root = new TreeNode(rootVal);

        root->left = helper(preorder, start, rootIdx - 1, map);
        root->right = helper(preorder, rootIdx + 1, end, map);

        return root;
    }   
};

/*Use a recursive approach to construct a binary tree by selecting the root from the preorder traversal and dividing the inorder traversal into left and right subtrees.
Maintain a preorderIndex to keep track of the current root in the preorder array and an inorderIndexMap for efficient lookup of indices in the inorder array.
Recursively build left and right subtrees, excluding the root index in the inorder array, until the entire tree is constructed.
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once.
Space Complexity: O(N), where N is the number of nodes, for the unordered_map storing the inorder indices and the recursive call stack.*/
#include<bits/stdc++.h>
using namespace std;
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
    int preorderIndex;
    unordered_map<int,int>inorderIndexMap;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preorderIndex=0;
        for(int i=0;i< inorder.size(); i++) {
            inorderIndexMap[inorder[i]] = i;
        }
        return arrayToTree(preorder, 0, preorder.size() - 1);
    }
    TreeNode* arrayToTree(vector<int>& preorder, int left, int right) {
        if (left > right) return nullptr;
        int rootValue = preorder[preorderIndex++];
        TreeNode* root = new TreeNode(rootValue);
        root->left = arrayToTree(preorder, left, inorderIndexMap[rootValue] - 1);
        root->right = arrayToTree(preorder, inorderIndexMap[rootValue] + 1, right);
        return root;
    }
};
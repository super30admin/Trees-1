/*
 *                  Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Leetcode : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * 
 * Time complexity : Worst Case O(n) where n is the number of nodes
 * Space complexity : Worst case O(n) where n is the number of nodes
 * 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Build the binary tree by recursively splitting the inorder array using a 
 *           hashmap for quick index lookup, while maintaining the current root index in the preorder array.
 */

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    unordered_map<int, int> hashmap;

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for (int i = 0; i < inorder.size(); i++) {
            hashmap[inorder[i]] = i;
        }

        int preorderIndex = 0;
        return build(preorder, preorderIndex, 0, inorder.size() - 1);
    }

    TreeNode* build(vector<int>& preorder, int& preorderIndex, int start, int end) {
        if (start > end) {
            return nullptr;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode* root = new TreeNode(rootValue);
        int rootIdx = hashmap[rootValue];

        root->left = build(preorder, preorderIndex, start, rootIdx - 1);
        root->right = build(preorder, preorderIndex, rootIdx + 1, end);

        return root;
    }
};

void printInorder(TreeNode* node) {
    if (node == nullptr) {
        return;
    }
    printInorder(node->left);
    cout << node->val << " ";
    printInorder(node->right);
}

int main() {
    Solution solution;
    vector<int> preorder = {3, 9, 20, 15, 7};
    vector<int> inorder = {9, 3, 15, 20, 7};

    TreeNode* root = solution.buildTree(preorder, inorder);

    // Print inorder traversal of the constructed tree to verify
    printInorder(root);

    return 0;
}

/*
 *                  Validate Binary Search Tree
 *
 * Leetcode : https://leetcode.com/problems/validate-binary-search-tree/description/
 * 
 * Time complexity : Worst Case O(n) where n is the number of nodes
 * Space complexity : Worst case O(h) where h is the height of the tree
 * 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - validity of a Binary Search Tree (BST) using an inorder traversal to verify 
 *            that each node's value is greater than its predecessor, leveraging a recursive 
 *            method with bounds tracking.
 */
#include <iostream>

/**
 * Definition for a binary tree node.
 */
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
    bool isValidBST(TreeNode* root) {
        TreeNode* prev = nullptr;
        return inorder(root, prev);
    }

private:
    bool inorder(TreeNode* root, TreeNode* &prev) {
        if (root == nullptr) return true;

        if (!inorder(root->left, prev)) return false;

        if (prev != nullptr && root->val <= prev->val) return false;
        prev = root;

        return inorder(root->right, prev);
    }
};

int main() {
    // Create a valid BST
    TreeNode* bst_root = new TreeNode(10);
    bst_root->left = new TreeNode(5);
    bst_root->right = new TreeNode(15);
    bst_root->left->left = new TreeNode(2);
    bst_root->left->right = new TreeNode(7);
    bst_root->right->left = new TreeNode(12);
    bst_root->right->right = new TreeNode(20);

    // Create a non-BST
    TreeNode* non_bst_root = new TreeNode(10);
    non_bst_root->left = new TreeNode(5);
    non_bst_root->right = new TreeNode(15);
    non_bst_root->left->left = new TreeNode(2);
    non_bst_root->left->right = new TreeNode(7);
    non_bst_root->right->left = new TreeNode(12);
    non_bst_root->right->right = new TreeNode(9); // This makes it a non-BST

    // Create an instance of the solution and check the BSTs
    Solution solution;
    bool result_bst = solution.isValidBST(bst_root);
    bool result_non_bst = solution.isValidBST(non_bst_root);

    // Print the results
    std::cout << (result_bst ? "The tree is a valid BST." : "The tree is not a valid BST.") << std::endl;
    std::cout << (result_non_bst ? "The tree is a valid BST." : "The tree is not a valid BST.") << std::endl;

    // Clean up memory
    delete bst_root->left->left;
    delete bst_root->left->right;
    delete bst_root->right->left;
    delete bst_root->right->right;
    delete bst_root->left;
    delete bst_root->right;
    delete bst_root;

    delete non_bst_root->left->left;
    delete non_bst_root->left->right;
    delete non_bst_root->right->left;
    delete non_bst_root->right->right;
    delete non_bst_root->left;
    delete non_bst_root->right;
    delete non_bst_root;

    return 0;
}

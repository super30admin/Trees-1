

98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.





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
 /*


TC = O(n)
SC = O(1)


 recursive solution 
 -----------------------

class Solution {
    TreeNode *prev;
public:
    bool isValidBST(TreeNode* root) {
        return helper(root);
    }
private: 
    bool helper(TreeNode* root) {
        //base
        if(root == NULL) return true;
        //logic
        bool left = helper(root->left);
        if ((prev != NULL ) && (prev->val >= root->val)) {
            return false;
        }
        prev = root;
        bool right = helper(root->right);

        
        return (left && right);
    }    
};


TC = O(n)
SC = O(n)

/*
iterative solution
------------------------
*/

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode *prev = NULL;

     while((root != NULL) || !st.empty()) {
        while((root != NULL)) {
            st.push(root);
            root = root->left;
        }
        root = st.top();
        st.pop();
        if ((prev!= NULL) && (prev->val >= root->val)) {
            return false;
        }
        prev = root;
        root = root->right;    
     }
        return true;
    }
};



// Time Complexity : O(n)
// Space Complexity : O(h); h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Iterative solution: Maintain a stack and keep adding root and its left children 
// 2. Once there are no left children, check if last element popped was greater than current popped element. If yes, return false
// 3. Move to the right of currently popped element and continue until root is null and the stack is empty

// Recursive will be same only stack push and pop will be implicit

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
    // iterative
    // bool isValidBST(TreeNode* root) {
    //     stack<TreeNode*> st;
    //     TreeNode* prev = nullptr;
    //     while(root!=nullptr || !st.empty()){
    //         while(root!=nullptr){
    //             st.push(root);
    //             root=root->left;
    //         }
    //         root = st.top();
    //         st.pop();
    //         if(prev!=nullptr && prev->val>=root->val)
    //             return false;
    //         prev=root;
    //         root=root->right;
    //     }
    //     return true;
    // }
    
    //recursive
    bool isValidBST(TreeNode* root) {
        TreeNode* prev=nullptr;
        return inorder(root, prev);
    }
    // reference to pointer
    // check for false at each recursive call
    bool inorder(TreeNode* root, TreeNode* &prev) {
        // base
        if(root==nullptr)
            return true;
        //logic
        if(!inorder(root->left, prev))
            return false;
        if(prev!=nullptr && prev->val>=root->val)
            return false;
        prev=root;
        if(!inorder(root->right, prev))
            return false;
        return true;
    }
};
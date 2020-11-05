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

// Recursive Solution:
// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(h) - h is the height of the tree. In worst case(skewed tree) h = n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    TreeNode* prev;
    bool inorder(TreeNode* node) {
        if(node == nullptr) return true;
        if(!inorder(node->left)) return false;
        if(prev != nullptr && node->val <= prev->val) return false;
        prev = node;
        return inorder(node->right);
        
    }
    bool isValidBST(TreeNode* root) {
        prev = nullptr;
        return inorder(root);
    }
};

// Iterative Solution:
// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(h) - h is the height of the tree. In worst case(skewed tree) h = n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* prev = nullptr;
        //int count = 0;
        
        while(root != nullptr || !st.empty()) {
            while(root != nullptr) {
                st.push(root);
                root = root->left;
            }
            root = st.top();
            
            st.pop();
            if(prev != nullptr && root->val <= prev->val) return false;
            //count++;
            prev = root;
            root = root->right;
        }
        return true;
    }
};

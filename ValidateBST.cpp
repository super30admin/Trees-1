// Time Complexity : O(n)
// Space Complexity : O(h)
//    where h : height of tree.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* 
 * Perform inorder traversal. Maintain previous pointer, while traversing a tree check if the current node value is less than the previous node value.
 * If not return false. Else return true.  
 */

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
    
    bool isValid;
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* prev = nullptr;
        while (root != nullptr || !st.empty())
        {
            while (root != nullptr)
            {
                st.push(root);
                root = root->left;
            }
            
            root = st.top();
            st.pop();
            cout << root->val;
            
            if (prev != nullptr && prev->val >= root->val)
            {
                return false;
            }
            prev = root;
            root = root->right;
            
        }
        return true;     
    }

};
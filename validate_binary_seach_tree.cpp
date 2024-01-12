// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is to create a stack and store left elements recursively. Then pop
// each element and then validate all the nodes according to the BST rule.

#include<vector>
#include<stack>
#include<unordered_map>

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
    bool flag = false;
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* prev = nullptr;
        while(!st.empty() || root != nullptr)
        {
            while(root != nullptr)
            {
                st.push(root);
                root = root->left;
            }
            root = st.top();
            st.pop();
            if(prev != nullptr && prev->val >= root->val)
            {
                return false;
            }
            prev = root;
            root = root->right;
        }
        return true;
    }   
};
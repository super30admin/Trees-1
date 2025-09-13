// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// In a BST, the values to the left of the root should be strictly less than the root, values to the right need to be strictly greater than the root
// Using this principle, we can see that when we move left, the min value possible remains the same as the min value for the parent and the max value becomes the value of the parent
// When we move right, the max remains max value for the parent, the min value becomes the actual value of the parent

// Your code here along with comments explaining your approach

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
private:
    void helper(TreeNode* root, long long max, long long min, bool& result) {
        // base case
        if(!root || !result) return;

        // logic
        if((max != LLONG_MAX && root->val >= max) || (min != LLONG_MIN && root->val <= min)) {
            result = false;
        }

        helper(root->left, root->val, min, result);
        helper(root->right, max, root->val, result);
    }
public:
    bool isValidBST(TreeNode* root) {
        bool result = true;
        helper(root, LLONG_MAX, LLONG_MIN, result);
        return result;
    }
};
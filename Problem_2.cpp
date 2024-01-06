/*
 ? Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <unordered_map>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
private:
    std::unordered_map<int, int> inorder_map = {};
    TreeNode* buildTreeHelper(std::vector<int>& preorder, int preStart, int preEnd, std::vector<int>& inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return nullptr;

        TreeNode* root = new TreeNode(preorder[preStart]);
        int mid = inorder_map[root->val];
        int numsLeft = mid - inStart;

        root->left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, mid - 1);
        root->right = buildTreeHelper(preorder, preStart + numsLeft +  1, preEnd, inorder, mid + 1, inEnd);

        return root;
    }
public:
    TreeNode* buildTree(std::vector<int>& preorder, std::vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++) {
            inorder_map[inorder[i]] = i;
        }

        return buildTreeHelper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
};
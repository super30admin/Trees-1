//Time Complexity and Space Complexity : O(n^2)
#include<bits/stdc++.h>
using namespace std;
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty()) 
            return nullptr;
        int val = preorder[0];
        auto it = find(inorder.begin(), inorder.end(), val);
        int i = distance(inorder.begin(), it);

        vector<int> il(inorder.begin(), inorder.begin() + i);
        vector<int> ir(inorder.begin() + i + 1, inorder.end());
        vector<int> pl(preorder.begin() + 1, preorder.begin() + 1 + il.size());
        vector<int> pr(preorder.begin() + 1 + il.size(), preorder.end());

        TreeNode* root = new TreeNode(val);
        root->left = buildTree(pl, il);
        root->right = buildTree(pr, ir);

        return root;
    }
};
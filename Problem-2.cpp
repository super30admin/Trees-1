

105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


TC = O(n) 
SC = O(n)

class Solution {
public:

    unordered_map<int, int> m;
    int idx;

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        idx = 0;
        for (int i=0; i< inorder.size(); i++) {
            m[inorder[i]] = i;
        }
        return helper( preorder, 0, inorder.size()-1);

    }
    TreeNode* helper(vector<int>& preorder, int start, int end) {
            //base
            if(start > end) {
                return nullptr;
            }
            //logic
            int rootval = preorder[idx];
            TreeNode* root = new TreeNode(rootval);
            idx++;
            int rootidx = m[rootval];
             
            root->left = helper(preorder, start, rootidx-1);
            root->right = helper(preorder, rootidx+1, end);
            return root;
    }

};

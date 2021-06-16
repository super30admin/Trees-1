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
    map<int, int> map;
    int index;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for ( int i =0; i < inorder.size(); i++){
            map.insert({inorder[i], i});
        }
        index = 0;
        return helper(preorder, inorder, 0, inorder.size()-1);
    }
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end){
        if ( start > end) return NULL;
                int rootIdx = map[preorder[index]];
        
        TreeNode* root = new TreeNode(preorder[index]);
        index++;
        root->left = helper(preorder, inorder, start, rootIdx-1);
        root->right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    
    }
};
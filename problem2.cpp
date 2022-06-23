
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
public:
    
    TreeNode* buildTreeRecur(  vector<int>& preorder, vector<int>& inorder, int leftidx, int rightidx,
                               int &preidx, unordered_map<int,int> & inordermap ){
        if( leftidx > rightidx){
            return nullptr;
        }
        
        TreeNode* root = new TreeNode( preorder[preidx] );
        preidx++;
        int inindex = inordermap[root->val];
        
        root->left = buildTreeRecur( preorder, inorder, leftidx, inindex-1, preidx, inordermap );
        root->right = buildTreeRecur( preorder, inorder, inindex+1, rightidx, preidx, inordermap  );
            
        return root;    
        
    }
    
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int>inordermap;  // value -> index
        for( int i=0; i<inorder.size(); i++){
            inordermap[inorder[i]] = i;
        }
        
        int preidx = 0;
        int leftidx = 0;
        int rightidx = inorder.size()-1;
        return buildTreeRecur( preorder, inorder, leftidx, rightidx, preidx, inordermap );
        
    }
};

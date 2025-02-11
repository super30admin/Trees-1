
// Time Complexity : O(n ) where n is the length of input array(preorder and inorder has same size)
// Space Complexity : O(n) + O(h) for the recursion where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The root is the first element of preorder vector. 
// Find the index root in the inorder vector using a map, Left subtree is the elements left to this index.
// Similary right subtree is the element right to this element.
// Iteratively find root, left subtree of the root, and right subtree of the root 

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
        TreeNode* constructBTree(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd, unordered_map<int,int> &mp){
            if(preStart > preEnd || inStart > inEnd) return NULL;
            TreeNode* root = new TreeNode(preorder[preStart]);
            int left = mp[root->val];
            int leftPre = left - inStart;
    
            root->left = constructBTree(preorder, preStart+1, preStart+leftPre, inorder, inStart, left-1, mp);
            root->right = constructBTree(preorder, preStart+leftPre+1, preEnd, inorder, left+1, inEnd, mp);
            return root;
        }
        TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
            int preStart = 0; int preEnd = preorder.size()-1;
            int inStart = 0; int inEnd = inorder.size()-1;
            unordered_map<int,int> mp;
            for(int i=inStart; i<=inEnd; i++){
                mp[inorder[i]] = i;
            }
            return constructBTree(preorder, preStart, preEnd, inorder, inStart, inEnd, mp);
        }
    };
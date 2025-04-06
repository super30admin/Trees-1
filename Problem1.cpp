// Time Complexity : O(n) n is array size
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Perform inorder traversal and check after traversing left node if it is smaller than root. 
// 2. Store current root of recursion as previous and lastly traverse right subtree.
// 3. In step 1 if root isn't greater flag it as zero else keep it as 1.


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
    int f=1,s=0;
    int prev;
    void chkValid(TreeNode* root){
        if(root==NULL){
            return;
        }
        chkValid(root->left);
        if(s!=0 && (root->val)<=prev){
            f=0;
        }
        s=1;
        prev=root->val;
        chkValid(root->right);
    }
    bool isValidBST(TreeNode* root) {
        chkValid(root);
        return f;
    }
};
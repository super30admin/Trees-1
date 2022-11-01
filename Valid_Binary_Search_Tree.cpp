/*
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
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
    
    bool isValidBST(TreeNode* root) {
        long preorderI = LONG_MIN;
        stack<TreeNode*> ns;
        while(root!=NULL){
            ns.push(root);
            root=root->left;
        }
        while(!ns.empty()){
            TreeNode *node = ns.top();
            ns.pop();
            //node
            if(node->val <= preorderI){
                return false;
            }
            
            preorderI = node->val;
            //right
            node = node->right;
            while(node!=NULL){
                ns.push(node);
                node=node->left;
            }
        }    
            
    return true;
    }
};
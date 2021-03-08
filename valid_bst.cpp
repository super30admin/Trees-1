//TC: O(n) where n is number of nodes
//SC: O(n) where n is the number of nodes.

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
        
        stack<TreeNode*> s;
        TreeNode* curr = root;
        TreeNode* prev = NULL;
        
        while(curr!=NULL || !s.empty()){
            if(curr!=NULL){
                s.push(curr);
                curr = curr->left;
            }
            else {
                curr = s.top();
                s.pop();
                
                if(prev!=NULL && curr->val <=prev->val)
                    return false;
                
                prev = curr;
                curr = curr->right;
                
            }
        }
        
        return true;
        
    }
};
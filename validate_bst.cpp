


// Time Complexity: O(N)
//Space Complexity: O(N)
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
        return helper(root,LONG_MIN,LONG_MAX);
//         stack<TreeNode*>st;
//         TreeNode* prev=NULL;
//         while(!st.empty()|| root!=NULL){
//             if(root!= NULL){
                
//                 st.push(root);
//                 root = root->left;
//             }
//             else{
//                 root = st.top();st.pop();
//                 if(prev && root->val<=prev->val)return false;
//                 prev = root;
     
//                 root = root->right;
//             }
//         }
//         return true;
        
        
    }
public:
    bool helper(TreeNode* root,long min,long max){
        if(root == NULL)return true;
        if(root->val <= min || root->val >=max)return false;
        return  helper(root->left,min,root->val) && helper(root->right,root->val,max);
    }
};
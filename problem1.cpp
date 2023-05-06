
// Time Complexity : O(n)
// Space Complexity :O(h) for recurrsive stack
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// we maintained a min and max value at each node, and  checked if the root->val lies in between the range.

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
//  */

// method 1
class Solution {
public:
    bool f(TreeNode* root, int  *mn,int *mx){
        if(root == NULL){
            return true;
        }
        if((mn!=NULL && root->val <=*mn) || (mx!=NULL && root->val>=*mx)){
            return false;
        }
        bool p = f(root->left,mn,& (root->val));

        bool q = f(root->right,&(root->val),mx);

        return p&&q;
    }
    bool isValidBST(TreeNode* root) {
        if(root==NULL){
            return true;
        }
        return f(root,NULL,NULL);
    }
};


// method 2
// as inorder traversal gives ascending order, we checked if prev node value is less than current node value.
// if not ,we returned false;


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
    //bool flag = true;;
     TreeNode* prev = NULL;
    bool inorder(TreeNode* root)
    {
        if(root==NULL)
        {
            return true;
        }
        bool p = inorder(root->left);
        if(prev!=NULL && prev->val>=root->val){
            return false;
        }
        prev = root;
        bool q = inorder(root->right);
        return p&&q;
        
    }
    bool isValidBST(TreeNode* root) {
        if(root==NULL){
            return false;
        }
        
        return inorder(root);;
        
    }
    
};
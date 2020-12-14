// ## Problem 1

// https://leetcode.com/problems/validate-binary-search-tree/

//Did this code run on leetcode :Yes

// Time complexity: O(n) 
// Space complexity: O(1)
// Idea- inorder traversal 


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
//idea- check inorder traversal by storing last node in previous ( by passing prev by reference)
class Solution {
public:
    
    bool isValidBST(TreeNode* root) {
    
        TreeNode* prev = NULL;
        return inorder ( root ,prev);
        
    }
    
    bool inorder(TreeNode* root, TreeNode* &prev){
        if(root ==NULL){
            return true;
        }
        
        if(inorder(root->left, prev) == false){
            return false;
        }
        
        if(prev!= NULL && prev->val >= root->val){
            return false;
        }
        
        prev =root;
        return inorder( root->right,prev);
    }
};


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
//idea- check inorder traversal by storing last node in previous
class Solution {
public:
    
    TreeNode* prev; //class data member
    bool isValidBST(TreeNode* root) {
    
        prev = NULL;
        return inorder ( root);
        
    }
    
    bool inorder(TreeNode* root){
        if(root ==NULL){
            return true;
        }
        
        if(inorder(root->left) == false){
            return false;
        }
        
        if(prev!= NULL && prev->val >= root->val){
            return false;
        }
        
        prev =root;
        return inorder( root->right);
    }
};


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
//idea- to check with a min and max
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        if(root ==NULL){
            return true;
        }
        
        return helper( root, NULL, NULL);
        
    }
    
    bool helper( TreeNode* root, TreeNode* min, TreeNode* max){
     if(root==NULL)
        return true;

    if(min!= NULL && root->val <= min->val )
        return false;

        
    if( max !=NULL && root->val  >= max->val)
        return false;
        
    return helper(root->left, min, root) && helper(root->right, root, max);
    
    }
    

};

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
//idea- to check and compare with global max min
//fails for case : [2147483647]

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        if(root ==NULL){
            return true;
        }
        
        int min = INT_MIN;
        int max = INT_MAX;
        
        return helper( root, min, max);
        
    }
    
    bool helper( TreeNode* root, int min, int max){
     if(root==NULL)
        return true;

    if(root->val < min || root->val  > max)
        return false;

    if((helper(root->left, min, (root->val)-1)) && helper(root->right, (root->val)+1, max))
        return true;
    else{
        return false;
        }
    } 

};



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

//idea- to check only for current root and recursive call to left and right subtree
//wrong -> fails for the case of [5,4,6,null,null,3,7]
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        if(root ==NULL){
            return true;
        }
        
        if( root->left != NULL ){
            if (root->left->val >= root->val){
                return false;
            }
        }
        
        if( root->right != NULL ){
            if (root->right->val <= root->val){
                return false;
            }
        }
        
        bool isLeftBST = isValidBST(root->left);
        bool isRightBST = isValidBST(root->right);
        
        return (isLeftBST && isRightBST ) ;
        
        
        
    }
};
// Time Complexity : O(n) 
// Space Complexity : O(n) use of external stack for iterative approach or system stack in case of recursion
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Validate BST

#include<iostream>
#include<stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};




// ITERATIVE

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        if(root == NULL)
            return false;
        
        TreeNode *curr = root;
        stack<TreeNode*> s1;
        TreeNode *prev = NULL;
        
        while(s1.empty() == false || curr != NULL){
            
            while(curr != NULL){
                s1.push(curr);
                curr = curr->left;
            }
            
            curr = s1.top();
            s1.pop();
            
            if(prev != NULL && prev->val >= curr->val)
                return false;
            
            prev = curr;
            
            curr = curr->right;
        }
        
        return true;
    }
};


// RECURSIVE

class Solution {
private:
    TreeNode *prev = NULL;
    bool flag;
    
public:
    bool isValidBST(TreeNode* root) {
            
        flag = true;
        
        validateInOrder(root);
        
        return flag;
    }
    
    void validateInOrder(TreeNode* root){
        
        if(root == NULL)        // NULL CASE 
            return;
        
        validateInOrder(root->left);
        
        if(prev != NULL && prev->val >= root->val){
            flag = false;
            return;
        }
        
        prev = root;
        
        validateInOrder(root->right);
    }
};
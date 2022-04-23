// Time Complexity                              :  O(N) where N is the number of nodes
// Space Complexity                             :  O(1) in the iterative approach but in the recursive approach O(h)
//                                                 where h is the height of the tree. 
//                                                 Max value of h can be N if it is a skewed tree
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/validate-binary-search-tree/submissions/

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
private: 
    TreeNode *prev;
public:
    bool isValidBST(TreeNode* root) {
        if(!root) return true;
        prev = NULL;
        return valid(root,NULL,NULL);
    }
    
    // locally passing max and min values and checking if the node value is in between them or not.
    bool valid(TreeNode *root, TreeNode *mn, TreeNode *mx) {
        if(!root) return true;
        
        if(mn and root->val <= mn->val) return false;
        if(mx and root->val >= mx->val) return false;
        
        return valid(root->right, root, mx) and valid(root->left, mn,root);
    }
    
    
    
    // before the right jump, we are changing the prev. hence it will not work
    bool valid0(TreeNode *root, TreeNode *prev) {
        if(!root) return true;
        
        if(!valid0(root->left,root)) return false;
        
        if(prev and root->val <= prev->val) return false;
        prev = root;
        
        if(!valid0(root->right,root)) return false;
        
        return true;
    }
    
    // modified the above code to get rid of the last if statement
    bool valid1(TreeNode *root) {
        if(!root) return true;
        if(!valid1(root->left)) return false;
        if(prev and root->val <= prev->val) return false;
        prev = root;
        return valid1(root->right);
    }
    
    // iterative approach
    bool valid2(TreeNode *root) {
        
        stack<TreeNode*> st;
        TreeNode *prev = NULL;
        
        while(root != NULL or st.empty() == false) {
            while(root != NULL) {
                st.push(root);
                root = root->left;
            }
            
            root = st.top();st.pop();
            if(prev and prev->val >= root->val) return false;
            prev = root;
            root = root->right;
        }
        return true;
    }
};
// Time complexity-O(log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// take the inorder traversal while maintaing a previous pointer to the root 
// if the prev pointer is ever greater than the currrent root to be printed return false

#include <iostream>
using namespace std;
#include<vector>
#include<stack>
 // Definition for a binary tree node.
  struct TreeNode {
     int val;
       TreeNode *left;`
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode *> storage;
        TreeNode * prev = nullptr;
        while(root!= nullptr || !storage.empty()){
            while(root != nullptr){ // left recursive call
                storage.push(root);
                root = root->left; 
            }
            
            root = storage.top();
            storage.pop();
            if(prev!= nullptr && prev -> val >= root-> val){
                return false;
            }
            else{
                prev= root;
            }
            root = root-> right;
        }
        return true;
    }
};
/**********************************************recursive approacch*******************************************************************/
class Solution {
public:
    TreeNode * prev = nullptr;
    bool isValidBST(TreeNode* root){
        return inOrder(root);
        
    }
    bool inOrder(TreeNode* root) {
        
        // base case 
        if (root == nullptr)
        {
            return true;
        }

        if (inOrder(root->left)==false){ // left  side recursion
            return false;
        };
        // root=st.pop()

        // logic 
        if(prev!= nullptr && prev -> val >= root-> val){
                return false;
            }
        return inOrder(root->right); // right side recursion
      
    }
};
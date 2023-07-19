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

/*

we are checking if the inorder traversal is in ascending order or not,

inorder - left-root-right.

we will use isValidate variable to keep track of irregualrity and once it bool variable becomes false, the recursion is terminated.
we will also be using a prev node to keep to track of node and check if prev is smaller than the root
, if thats the case, we will continue, otherwise the flag will become false and the recursion is termianted.

*/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
    struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
public:
    TreeNode* prev;
    bool isValid;
    bool isValidBST(TreeNode* root) {
        isValid = true;
        inOrder(root);
        return isValid;
        
    }

    void inOrder(TreeNode* root){

        if(root==nullptr){
            return;
        }

        if(isValid)

        {inOrder(root->left);

        if(prev != NULL && prev->val>=root->val){
            isValid=false;
        }

        prev = root;}

        if(isValid){inOrder(root->right);}

    }
};
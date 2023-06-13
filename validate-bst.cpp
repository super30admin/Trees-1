// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>

using namespace std;

//Implementing a tree class
class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

//early exit if the flag becomes false as we dont need to traverse through the entire tree
class Solution {
public: 
    TreeNode* prev;
    bool flag;
    bool isValidBST(TreeNode* root) {
        this->flag = true;
        inorder(root);
        return this->flag;
    }
private:
    void inorder(TreeNode* root){
        //base case
        if(root == nullptr) return;

        if(flag) inorder(root->left);

        if(prev != nullptr && prev->val >= root->val){
            flag = false;
        }
        prev = root;

        if(flag) inorder(root->right);
    }
};

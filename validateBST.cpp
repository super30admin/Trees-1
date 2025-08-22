#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
We're doing an in-order traversal to visit nodes in increasing order.
At each step, we check if the current node is greater than the previous one.
If any node violates this order, we set the flag to false.
*/
class Solution{
bool flag;
    TreeNode* prev;
private:
    void helper(TreeNode* root){
        
        if(root==nullptr) return;
        helper(root->left);
        if(prev != nullptr && prev->val >= root->val) flag=false;
        prev=root;
        helper(root->right);
    }
public:
    bool isValidBST(TreeNode* root) {
        this->flag = true;
        helper(root);
        return flag;

    }
};

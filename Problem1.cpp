//
// Created by shazm on 7/22/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

//Time Complexity : O(n) where n == length of tree
//Space Complexity  : O(n) where n == number of nodes
//Algorithm : eg:   2
//                1   4
// if left value < current root value check tree with left as node.
// if right value > current root value check tree with right as node.
// if both above == false, then return false or else reach NULL node and return true.

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        if((root->left == NULL) || root->left->val < root->val){
            isValidBST(root->left);
        }else{return false;}

        if((root->right == NULL) || root->right->val > root->val){
            isValidBST(root->right);
        }else{return false;}
    }
};

int main(){
    Solution s;
    TreeNode* Node = new TreeNode(5);
    Node->left = new TreeNode(1);
    Node->right = new TreeNode(4);
    cout<<s.isValidBST(Node);
    return 0;
}
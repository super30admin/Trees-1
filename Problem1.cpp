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

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if(root == NULL){return true;}
        bool l = recurr(root->left,root->val,false);
        bool r = recurr(root->right,root->val,true);

        if(l == true && r == true){
            return true;
        }
        return false;
    }
private:
    bool recurr(TreeNode* root, int value, bool right){
        if(root == NULL){
            return true;
        }
        bool check;
        if(right){
            check = root->val > value;
        }else{
            check = root->val < value;
        }
        bool retValLeft = false; bool retValRight = false;
        if(((root->left == NULL) || (root->left->val < root->val)) && check){
            retValLeft = recurr(root->left,value,right);
        }else{retValLeft = false;}

        if(((root->right == NULL) || (root->right->val > root->val)) && check){
            retValRight = recurr(root->right,value,right);
        }else{retValRight = false;}

        if(retValRight == true && retValLeft == true){
            return true;
        }
        return false;
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
#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;
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
    TreeNode* prev;
    bool isValid = true;
    void inorder(TreeNode* root){
        if(root == NULL){
            return;
        }
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root->right);
    }

    bool isValidBST(TreeNode* root) {
        inorder(root);
        return isValid;
    }
};




int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}

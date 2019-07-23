//Time Complexity : O(n) --> N == length of tree
//Space Complexity: O(n) --> N == number of nodes
//Approach: 

/* 
1. Use min & max pointers to keep a track of the bounds in which the root->val must operate in order to be a BST
2. If the entire traversal is successful, it is BST 
*/

#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  bool isValidBST(TreeNode* root, int min = LONG_MIN, long max = LONG_MAX) {
    if (root == NULL) return true; //base case
    if (root->val <= min || root->val >= max) return false;

    return isValidBST(root->left, min, root->val) && isValidBST(root->right, root->val, max);
  }
};
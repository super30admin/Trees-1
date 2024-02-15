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
Time Complexity: O(N)
Space Complexity: O(1)

Intution: An inorder traversal of a BST will result in a strictly-increasing array (if the values are unique)
So maintain the previous encountered value and compare with the current node's value at each traverse 
*/
class Solution {
public:
    bool set;
    int prev;

    bool call(TreeNode* root){
      if(root==nullptr)  return true;

      bool left = call(root->left);

      //check if strictly increasing
      if(set && root->val <= prev)  return false; //set = flag to indicate if a value has been encountered yet
      
      prev = root->val;
      set = true;

      bool right = call(root->right);

      return left && right;
    }

    bool isValidBST(TreeNode* root) {
        set = false;
        return call(root);
    }
};

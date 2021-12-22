//Time Complexity - O(n)
//Space Complexity - O(Height of the tree)
// Problem successfully executed on leetcode
// Had to take min and max NULL at first in order to incorporate the logic for edge cases nodes such as INT_MIN and INT_MAX

#include<iostream>
using namespace std;


  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class Solution {
public:
    bool isValid=true;
    bool isValidBST(TreeNode* root) {
        
        valid(root,NULL,NULL);
        return isValid;
    }
    
    void valid(TreeNode* root, int* min, int* max)
    {
        
        if(root==NULL)
        {
            return;
        }
        if((min != NULL && root->val <= *min) || (max != NULL && root->val >= *max))
        {
            isValid=false;
            return;
        }
        
        valid(root->left,min,&root->val);
        
        valid(root->right,&root->val,max);
    }
};
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
    int n, p;
    unordered_map<int,int> pos;
    vector<int> pre;

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)

    For a value v in pre-order, let idx be its index in inorder
    Then all values from 0 to idx - 1 will be in its left subtree, 
    and values from idx + 1 to n-1 will be in its right subtree

    This procedure follows recursively.

    At every call, we increment the global vairable p and pick root-value from inorder one by one sequentially
    */

    TreeNode* call(int l, int r){
      if(l>r)  return nullptr;

      int val = pre[p];
      p++;

      TreeNode* root = new TreeNode(val);
      int left_l =  l, left_r = pos[val]-1;
      int right_l = pos[val] + 1, right_r = r;

      root->left = call(left_l, left_r);
      root->right = call(right_l, right_r);

      return root;
    }

    TreeNode* buildTree(vector<int>& pre, vector<int>& in) {
      n = pre.size();  
      this->pre = pre;
      p = 0;
      for(int i=0;i<pre.size();i++)  pos[in[i]] = i;


      return call(0,n-1);
        
    }
};

//Solution using iterative
// Time Complexity : O(N)
// Space Complexity : O(H) H-->Height of Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Solution using Recursion
// Time Complexity : O(N)
// Space Complexity : O(H) H-->Height of Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    
    bool isValidBST(TreeNode* root) {
        TreeNode* prev = NULL;
        stack<TreeNode*> stack;
        
        while(root!=NULL || !stack.empty()){
            if(root!=NULL){
                stack.push(root);
                root = root->left;
            }
            else{
                root = stack.top();
                stack.pop();
                if(prev!=NULL && prev->val >= root->val) 
                    return false;
                // prev = root;
                root = root->right;
            }
        }
        //return inorder(root,prev);
    }
    
  bool inorder(TreeNode* root,TreeNode* &prev){
      //base case
     
      if(root==NULL){
          return true;
      }
      if(inorder(root->left, prev)==false) return false;  
      if(prev!= NULL && prev->val >=root->val) return false;   
      prev = root;
      return (inorder(root->right ,prev));   
  }  
};

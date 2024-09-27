// Validate Binary Search Tree
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

//Definition for a binary tree node.
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
  
    //Approach 1: Recursive inorder traversal;
    //TC: O(N), SC:O(N)
    vector<TreeNode*> v;
    bool isValidBST(TreeNode* root) {
        int i=0;
        if(root==NULL)
            return true;
        validBST(root);
        for(i=0;i<v.size()-1;i++){
            if(v[i]->val>=v[i+1]->val)
                return false;
        }
        return true;
    }
    
    void validBST(TreeNode* root){
        if(root!=NULL){
            validBST(root->left);
            v.push_back(root);
            validBST(root->right);
        }
    }
    //------------------------------------------
    //Approach 2:  Iterative Inorder traversal
    //TC: O(N), SC:O(N)
     bool isValidBST2(TreeNode* root) {
         stack<TreeNode*> s;
         long min=LONG_MIN;
         while(!s.empty() || root!=NULL){
             while(root!=NULL){
                 s.push(root);
                 root=root->left;
             }
             root=s.top();
             s.pop();
             if(root->val<=min)
                 return false;
             min=root->val;
             root=root->right;
         }
         return true;
     }
    
     /*----------------------------------------------
     Approach 3: Recursion
     TC: O(N), SC:O(N) */
     bool isValidBST3(TreeNode* root) {
        return validate(root, NULL, NULL);
         
     }
    
    bool validate (TreeNode* root, TreeNode* lowerLimit, TreeNode* upperLimit){
        if(root == NULL)
            return true;
        
        if(lowerLimit != NULL && root->val <= lowerLimit->val) return false;
        if(upperLimit != NULL && root->val >= upperLimit->val) return false;
        
        //validate Left sub tree && right sub tree
        return validate(root->left, lowerLimit, root) && validate(root->right, root, upperLimit);
    

    }
    
};

int main(int argc, const char * argv[]) {
    TreeNode* root = new TreeNode(20);
    root->left = new TreeNode(2);
    root->right = new TreeNode(5);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(3);
    Solution s;
    if(s.isValidBST3(root))
        cout<<"Is BST"<<endl;
    else
        cout<<"Not a BST"<<endl;
          
    return 0;
}

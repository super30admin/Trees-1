/*
  Construct_Tree_From_Preorder_and_Inorder.cpp
 
  Approach: Preorder gives us the root of subtree at each level. Inorder gives us the left and right subtree of given root. Use hashmap to store the each node and corresponding index value from inorder array.
   
  TC: O(N), SC: O(N);
*/
#include <iostream>
#include <vector>
#include <unordered_map>

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
    unordered_map<int, int> inorder_tracker;
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
       if(preorder.size() == 0)
           return NULL;
        for(int i=0;i<inorder.size();i++) inorder_tracker[inorder[i]] = i;
        TreeNode* root = constructBST(preorder, 0, preorder.size());
        return root;
    };
    
    int id=0;
    TreeNode* constructBST(vector<int>& preorder, int start, int end){
        if(start >= end ) return NULL;
        int rootval=preorder[id++];
        TreeNode* root = new TreeNode(rootval);
        int index = inorder_tracker[rootval];
        root->left = constructBST(preorder, start, index);
        root->right = constructBST(preorder, index+1, end);
        return root;
    }
    
    void inorderTraversal(TreeNode* node){
        if(node!=NULL){
            inorderTraversal(node->left);
            cout<<node->val<<"\t";
            inorderTraversal(node->right);
        }
    }
     
};

int main(int argc, const char * argv[]) {
    vector<int> preorder = {3,9,20,15,7};
    vector<int> inorder = {9,3,15,20,7};
    Solution s;
    TreeNode * root= s.buildTree(preorder,inorder);
    s.inorderTraversal(root);
    return 0;
}

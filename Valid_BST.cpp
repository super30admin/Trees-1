//Time Complexity : O(n)
//Space Complexity : O(n)

#include<iostream>
#include<vector>
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
    bool isValidBST(TreeNode* root) {
        return helper(root, nullptr, nullptr);
    }
    
    bool helper(TreeNode* root, int* mini, int* maxi){

        if(root == nullptr) 
            return true;
         if(maxi != nullptr && root->val >= *maxi){
            return false;
        }
        if(mini != nullptr && root->val <= *mini){
           return false;
        }   
        return helper(root->left, mini, new int(root->val)) && helper(root->right, new int(root->val), maxi);
    }
};
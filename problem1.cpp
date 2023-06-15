/*

Time Complexity: O(N) ->total number of nodes maximum;
Space Complexity: O(H) ->height of the tree; // stack memory.
Did it run on leetcode : Yes

*/


#include<iostream>

using namespace std;

struct TreeNode{
    int val{};
    struct TreeNode* left{nullptr};
    struct TreeNode* right{nullptr};
    TreeNode(int x = 0,TreeNode* Left = nullptr,TreeNode* Right = nullptr):val(x),left(Left),right(Right){};
};


/*

Using Void based recurrsion.


*/

class Solution {

public:
    bool flag{true};
    TreeNode* prev{nullptr};
    void helper(TreeNode* curr){
        //base
        if(curr == nullptr) return;
        //logic
        
        if (flag) helper(curr->left);
        if((prev!=nullptr) && (prev->val)>=(curr->val)) flag = false;
        prev = curr;
        if(flag) helper(curr->right);

    }
    bool isValidBST(TreeNode* root) {
        helper(root);
        return flag;
    }
};

/*

Using Bool based recursion

*/

class Solution_2 {
public:
    TreeNode* prev{nullptr};
    bool helper(TreeNode* curr){
        //base case
        if(curr == nullptr) return true;
        //left side
        if(helper(curr->left) == false) return false;
        if((prev!=nullptr) && prev->val>=curr->val) return false;
        prev = curr;
        //right size
        return helper(curr->right);
    }
    bool isValidBST(TreeNode* root) {
        return helper(root);
    }
};

/*

Using preorder traversal and checking if the conditions are met or not.

*/

class Solution_3 {
public:
    bool helper(TreeNode* root,long long int left,long long int right){
        if(root == nullptr) return true;
        //cout<<root->val<<endl;
        if((root->val)<=left || (root->val)>=right) return false;
        //cout<<root->val<<endl;
        return(helper(root->left,left,root->val) && helper(root->right,root->val,right));
    }
    bool isValidBST(TreeNode* root) {
            return helper(root,LLONG_MIN,LLONG_MAX);
    }
};


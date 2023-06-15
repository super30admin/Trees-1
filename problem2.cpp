/**
// Time Complexity : O(N)
// Space Complexity :O(H) -> height of the tree for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
Managing pointers for the inorder tree


// Your code here along with comments explaining your approach
You take root from the preorder
From that root you find the right subtree and left subtree from the inorder array
In finding the subtree we pass the index of the subtree related to inorder array
if the start exceeds end we return null indicating the end of the node.

*/




#include<vector>
#include<unordered_map>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x,TreeNode* left,TreeNode* right):val(x),left(left),right(right){};
    TreeNode():val(0),left(nullptr),right(nullptr){};
    TreeNode(int x):val(x),left(nullptr),right(nullptr){};

};

class Solution {
    int idx{};
public:

    TreeNode* helper(unordered_map<int,int>& hash_set,vector<int>& preorder,int start, int end){
        if(start>end) return nullptr;
        int val = preorder.at(idx);
        int gg = hash_set[val];
        idx++;
        TreeNode* root = new TreeNode(val,helper(hash_set,preorder,start,gg-1),helper(hash_set,preorder,gg+1,end));
        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map <int,int> hash_set{};
        int n = inorder.size();
        for(int i{};i<n;++i){
            hash_set[inorder.at(i)] = i;
        }
        int val = preorder.at(idx);
        int gg = hash_set[val];
        idx++;
        TreeNode* root = new TreeNode(val,helper(hash_set,preorder,0,gg-1),helper(hash_set,preorder,gg+1,n-1));
        return root;
    }
};
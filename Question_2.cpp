#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <unordered_map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

TreeNode* recurse(vector<int>& preorder, vector<int>& inorder,unordered_map<int,int>&table,int p1,int p2,int i1,int i2){
    if(p1>p2||i1>i2) return NULL;
    cout<<preorder[p1]<<endl;
    if(p1==p2||i1==i2){
        TreeNode* node = new TreeNode(preorder[p1]);
        return node;
    }
    int inorder_root_index = table[preorder[p1]];
    int left_subtree_length = inorder_root_index-i1;
    TreeNode* leftChildNode = recurse(preorder,inorder,table,p1+1,p1+left_subtree_length,i1,inorder_root_index-1);
    TreeNode* rightChildNode = recurse(preorder,inorder,table,p1+left_subtree_length+1,p2,inorder_root_index+1,i2);
    TreeNode* node = new TreeNode(preorder[p1],leftChildNode,rightChildNode);
    return node;
}
TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    int n = inorder.size();
    unordered_map<int,int>table;
    for(int i=0;i<=n-1;i++) table[inorder[i]]=i;
    return recurse(preorder,inorder,table,0,n-1,0,n-1);
}

int main(){
    vector<int> preorder = {3,9,20,15,7};
    vector<int> inorder = {9,3,15,20,7};
    TreeNode* root = buildTree(preorder,inorder);
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(n)
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Explanation: The tree is constructed from the preorder and inorder traversal.
#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isValidBST(TreeNode* root) {
    if(!root) return true;
    bool leftChild = isValidBST(root->left);
    bool rightChild = isValidBST(root->right);
    TreeNode* temp = root->left;
    if(temp) while(temp->right) temp = temp->right;
    TreeNode* temp2 = root->right;
    if(temp2) while(temp2->left) temp2 = temp2->left;
    bool currNode = ((!temp)||(temp->val<root->val))&((!temp2)||(temp2->val>root->val));
    return leftChild&&rightChild&&currNode;

}
int main(){
    TreeNode* root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);
    cout<<isValidBST(root);
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(h)
// Input: [2,1,3]
// Output: true
// Explanation: The tree is a valid BST.

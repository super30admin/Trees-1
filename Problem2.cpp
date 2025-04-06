// Time Complexity : O(n) n is array size(# of nodes).
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Create function build tree which takes root, first & last element of inorder and both traversal arrays. 
// 2. find index of root in inorder traversal and all elements in left side is left subtree of that root and similar for right.
// 3. In each recursion call create node for root and call to build left(root=root+1) and right(root=root+#of elements on right of root in inorder array+1) subtree.


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
    TreeNode* bt(vector<int>& preorder, vector<int>& inorder, int rt,int f,int l,TreeNode* t){
        int io;
        if(f>l){
            t=nullptr;return t;
        }
        t=new TreeNode(preorder[rt]);
        for(int i=f;i<=l;i++){
            if(inorder[i]==preorder[rt]){
                io=i;break;
            }
        }
        (t->left)=bt(preorder,inorder,rt+1,f,io-1,t->left);
        (t->right)=bt(preorder,inorder,rt+io+1-f,io+1,l,t->right);
        return t;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int st=0;
        int f=0,l=inorder.size()-1;
        return bt(preorder,inorder,st,f,l,nullptr);
    }
};
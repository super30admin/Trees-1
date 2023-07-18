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

    int rdx = 0; // running on the preorder
         map<int, int> m;
   
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {

     
        int n = inorder.size();

        TreeNode* ans = pre(preorder,inorder,0,n-1,n);
        return ans;

    }

    int findpos(vector<int>& inorder,int rootVal,int n){
        for(int i = 0;i<n ; i++){
            if(rootVal == inorder[i]){
                return i;
            }
   
        }
        return -1;
    }

    TreeNode* pre(vector<int>& preorder, vector<int>& inorder, int s,int e,int size){
            if(s>e || rdx >= size){
                return NULL;
            }

            int rootVal = preorder[rdx];
            rdx++;
            TreeNode* root = new TreeNode(rootVal);
            int rootIdx = findpos(inorder,rootVal,size);
            root->left = pre(preorder,inorder,s,rootIdx-1,size);
            root->right = pre(preorder,inorder,rootIdx+1,e,size);

      return root;
    }
};
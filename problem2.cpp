//Time Complexity - O(N)
//Space Complexity - O(N)
class Solution {
public:
    unordered_map<int,int>m;
    int idx;
    TreeNode* helper(vector<int>&preorder,vector<int>&inorder,int start,int end)
    {
        if(start>end)
            return NULL;
        int rootval=preorder[idx];
        idx++;
        TreeNode* root=new TreeNode(rootval);
        int rootidx=m[rootval];
        root->left=helper(preorder,inorder,start,rootidx-1);
        root->right=helper(preorder,inorder,rootidx+1,end);
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i=0;i<inorder.size();i++){
            m[inorder[i]]=i;
        }
        return helper(preorder,inorder,0,preorder.size()-1);
    }
};
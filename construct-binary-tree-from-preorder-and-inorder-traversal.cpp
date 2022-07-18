class Solution {
public:
    //Time complexity : O(N)
    //Space complexity : O(N)
    unordered_map<int,int> h;
    int idx=0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        for(int i=0;i<inorder.size();i++){
            h[inorder[i]]=i;
        }
        return treebuilder(preorder,inorder,0,inorder.size()-1);
    }
    
    TreeNode* treebuilder(vector<int>&preorder,vector<int>&inorder,int start,int end){
        if(start>end)return NULL;
        int curr=preorder[idx];
        idx++;
        TreeNode *root=new TreeNode(curr);
        int pivot=h[curr];
        root->left=treebuilder(preorder,inorder,start,pivot-1);
        root->right=treebuilder(preorder,inorder,pivot+1,end);
        
        return root;
    }
};
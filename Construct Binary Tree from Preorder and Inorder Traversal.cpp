//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        unordered_map<int,int> mp;
        for(int i=0;i<inorder.size();i++){
            mp[inorder[i]]=i;
        }
        
        int len=inorder.size()-1;
        return builttree(preorder,0,len,mp);
    }
    
    TreeNode* builttree(vector<int> preorder,int start,int end,unordered_map<int,int> mp){
        
        static int preindex=0;
        if(start>end){
            return NULL;
        }
        
        int num=preorder[preindex++];
        TreeNode* root=new TreeNode();
        root->val=num;
        
        if(start==end){
            return root;
        }
        
        int inindex=mp[num];
        root->left=builttree(preorder,start,inindex-1,mp);
        root->right=builttree(preorder,inindex+1,end,mp);
        
        return root;
    }
};
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    unordered_map<int,int>map;
    int idx=0;
    TreeNode* helper(vector<int> preorder,vector<int> inorder,int start,int end)
    {
        if(start>end) return nullptr;
        //
       int rootval=preorder[idx];
        idx++;
       TreeNode* root=new TreeNode(rootval);
        int rootidx=map[rootval];
        root->left=helper(preorder,inorder,start,rootidx-1);
        root->right=helper(preorder,inorder,rootidx+1,end);
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i=0;i<inorder.size();i++)
        {
            map[inorder[i]]=i;
        }
        return helper(preorder,inorder,0,inorder.size()-1);
    }
};

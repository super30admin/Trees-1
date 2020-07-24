// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Recursion

class Solution {
public:
    int index = 0;
    unordered_map<int,int> map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        if(preorder.size()==0 || inorder.size()==0){
            return NULL;
        }

        for(int i=0;i<inorder.size();i++){
            map[inorder[i]] = i;
        }
        
        return helper(preorder,inorder,0,inorder.size()-1);
        
    }
    
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder,int start,int end){
        
        if(start> end || index == preorder.size()){
            return NULL;
        }
        TreeNode *root = new TreeNode(preorder[index]);
        int inind = map[preorder[index]];
        index++;
        root->left = helper(preorder,inorder,start,inind-1);
        root->right = helper(preorder,inorder,inind+1,end);
        return root;
        
        
    }
};

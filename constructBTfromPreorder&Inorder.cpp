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
    int pre_idx=0;
    unordered_map<int,int> um;
    vector<int> preorder;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        this->preorder=preorder;
        for (int i=0;i<inorder.size();i++) {
            um[inorder[i]]=i;
        }
        return helper(0,preorder.size()-1);
    }
    
    TreeNode *helper(int left,int right) {
        //cout<<left<<" "<<right<<" pre_idx: "<<pre_idx<<" root value: "<<preorder[pre_idx]<<endl;
        
        if (left>right) return NULL;
        
        int root_val=preorder[pre_idx];
        
        TreeNode *root=new TreeNode(root_val);
        pre_idx++;
        
        int index=um[root_val];
        
        root->left=helper(left,index-1);
        root->right=helper(index+1,right);
        
        
        return root; 
    }
   
};
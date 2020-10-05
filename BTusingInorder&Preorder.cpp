//time complexity: O(n*2)
//space complexity:O(n)
//approach: checking left start, left end, right start, right end in the inorder and preorder array
//recursive
//solved on leetcode? yes
//problem faced? yes, very tricky to code!!

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size()==0 && inorder.size()==0)
            return NULL;
        int n=preorder.size();
        return helper(inorder,preorder,0,n-1,0,n-1);
    }
    TreeNode* helper(vector<int>& inorder, vector<int>& preorder, int inS, int inE, int preS, int preE)
    {
        if(inS>inE)
            return NULL;
        
        int rootval=preorder[preS];
        int rootindex=-1;
        for(int i=inS; i<=inE; i++)
        {
            if(inorder[i]==rootval)
            {
                rootindex=i;
                break;
            }
        }
        
        int leftinS=inS;
        int leftinE=rootindex-1;
        int leftpreS=preS+1;
        int leftpreE=leftinE-leftinS+leftpreS;
        int rightpreS=leftpreE+1;
        int rightpreE=preE;
        int rightinS=rootindex+1;
        int rightinE=inE;
        
        TreeNode* root= new TreeNode(rootval);
        root->left=helper(inorder,preorder,leftinS,leftinE,leftpreS,leftpreE);
        root->right=helper(inorder,preorder,rightinS,rightinE,rightpreS,rightpreE);
        
        return root;
    }
};
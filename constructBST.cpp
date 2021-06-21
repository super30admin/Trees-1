//I have used recusrive approach to divide and conquer the sub trees 
//used hashmaps for O(1) search in the inorder traveral for indices in preorder
//Time complexity- O(n)
//Space complexity- O(n) //stack call space

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
     unordered_map<int,int>m;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
       
        
        for(int i=0;i<inorder.size()-1;i++)
        {
            m[inorder[i]]=i;
        }
        return helper(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }
    
    TreeNode* helper(vector<int>& preorder, int startP, int endP,vector<int>& inorder, int startI, int endI)
    {
        //Base case: size 0 and size 1 sub problem 
        if(startP>endP)
        {
            return NULL;           
        }
        if(startP==endP)
        {
         // TreeNode* node= TreeNode(preorder[startP]);
            return new TreeNode(preorder[startP]);
        }
        //Recursive Case
        //make sure to locate a root in pre-order 
        TreeNode* root=new TreeNode(preorder[startP]);
        int rootindex=m[preorder[startP]];
        int numleft=rootindex-startI;
        int numright=endI-rootindex;
        root->left=helper(preorder,startP+1,startP+numleft,inorder,startI, rootindex-1);
            root->right=helper(preorder,numleft+startP+1, endP,inorder, rootindex+1,endI);
        
        
        return root;
    }
};

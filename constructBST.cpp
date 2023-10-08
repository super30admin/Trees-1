//TC: O(n)
//SC: O(n)

//Approach: make use of preoder to find root of the tree
//find the index of root in inorder -> that we can get from hashmap
//then find size of left and right subtrees 
//make use of these numleft and numright to find indices for the next subtree construxction - each time we consider first halves of the trees
//and make it equal to left and right pointers of rhe root
class Solution {
public:
unordered_map<int,int> map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        for(int i=0;i<inorder.size();i++)
        {
            map[inorder[i]]=i;
        }
    return dfs(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1);
    }
    TreeNode* dfs(vector<int>& preorder, int startP, int endP, vector<int>& inorder, int startI, int endI)
    {
        //base
        if(startP>endP)
            return nullptr;
        if(startP==endP)
            return new TreeNode(preorder[startP]);
        //recursive call
            TreeNode* root=new TreeNode(preorder[startP]);
            int index=map[preorder[startP]];
            int numleft=index-startI;
            int numright=endI-index;
    
        root->left=dfs(preorder, startP+1, startP+numleft, inorder, startI, index-1);
        root->right=dfs(preorder, startP+numleft+1, endP, inorder, index+1, endI);
        return root;
    }
};
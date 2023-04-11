class Solution {
    // TC - O(n)
    // SC - O(n) for map + O(d)(depth of tree)
public:
    int preOrderIndex;
    unordered_map <int,int> umap;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i =0; i< inorder.size();i++){
            umap[inorder[i]] = i; 
        }
       TreeNode* root = buildTreeRecur(preorder, 0, inorder.size()-1);
        return root;a
    }

    TreeNode* buildTreeRecur(vector<int>& preorder, int stInIndex, int enInIndex){
        if(enInIndex<stInIndex) return nullptr;
            int rootIndex = umap[preorder[preOrderIndex]];
            TreeNode* root = new TreeNode(preorder[preOrderIndex++]);
            root->left = buildTreeRecur(preorder,stInIndex,rootIndex-1);
            root->right = buildTreeRecur(preorder,rootIndex+1,enInIndex);
            return root;


    }
};
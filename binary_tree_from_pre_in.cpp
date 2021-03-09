
// Time Complexity: O(N)
//Space Complexity: O(N)


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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int p = 0;
     
        return buildTreeHelper(preorder,inorder,0,inorder.size()-1,p);
        
    }

    
public:
    TreeNode* buildTreeHelper(vector<int>& preorder, vector<int>& inorder,int is,int ie,int &preIterator){
        // static int preIterator = 0;
        if(is>ie)return NULL;
        int pos;
        
        TreeNode* temp = new TreeNode(preorder[preIterator++]);
        if(is == ie)return temp;
        for(int i = is; i<=ie;i++){
            if(inorder[i]==temp->val){
                pos = i;
                break;
            }
        }
        temp->left = buildTreeHelper(preorder,inorder,is,pos-1,preIterator);
        temp->right = buildTreeHelper(preorder,inorder,pos+1,ie,preIterator);


        return temp;
    }
};
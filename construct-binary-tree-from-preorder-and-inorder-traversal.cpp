//Time complexity - O(n)
//Space complexity - O(n)

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0) return NULL;
        int p = 0,i = 0;
        
        stack<TreeNode*> st;
        TreeNode* root = new TreeNode(preorder[p++]);
        st.push(root);
        TreeNode* ret = root;
        
        while(i<inorder.size() && p<preorder.size()){
            
            if(!st.empty() && st.top()->val!=inorder[i]){
                root->left = new TreeNode(preorder[p]);
                root = root->left;
                st.push(root);
                p++;
            }else{
                while(!st.empty() && st.top()->val == inorder[i]){
                    root = st.top();
                    st.pop();
                    i++;   
                }
                root->right = new TreeNode(preorder[p++]);
                root = root->right;
                st.push(root);
            }
            
        }
        
        return ret;
        
    }
};
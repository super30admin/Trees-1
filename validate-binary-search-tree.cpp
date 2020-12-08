//Time Complexity - O(n)
//Space comlexity - O(n)

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack <TreeNode*> st;
        stack <TreeNode*> lowst;
        stack <TreeNode*> highst;
        TreeNode *high, *low;
        
        st.push(root);
        lowst.push(NULL);
        highst.push(NULL);
        
        while(!st.empty()){
            
            root = st.top();st.pop();
            high = highst.top();highst.pop();
            low = lowst.top();lowst.pop();
            
            if(low!=NULL && root->val<=low->val) return false;
            if(high!=NULL && root->val>=high->val) return false;
            
            if(root->left!=NULL) {
                st.push(root->left);
                highst.push(root);
                lowst.push(low);
            }
            if(root->right!=NULL){
                st.push(root->right);
                lowst.push(root);
                highst.push(high);
            }
            
        }
        
        return true;

    }
};
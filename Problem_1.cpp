//Time Complexity: O(N), where n is the elements in the tree.
//Space Complexity: O(N), where n is the height of the stack.

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* trav = root;
        TreeNode* prev = NULL;
        while(trav != NULL || !st.empty()){
            while(trav != NULL){
                    st.push(trav);
                    trav = trav->left;
            }
            trav = st.top();
            st.pop();
            if(prev != NULL && prev->val >=trav->val){
                return false;
            }
            else{
                prev = trav;
                trav = trav->right;   
            }
        }
        return true;
    }
};
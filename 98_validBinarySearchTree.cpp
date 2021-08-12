// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(H) where h is the number of levels of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//recursive
class Solution {
public:
    TreeNode* prev;
    bool isValid;
    bool isValidBST(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
    }
    
    void inorder(TreeNode* root){
        if(root == NULL){
            return;
        }
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root->right);
    }
};

//iterative
class Solution {
public:
    TreeNode* prev;
    bool isValid;
    bool isValidBST(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        isValid = true;
        stack<TreeNode*> s;
        while(root != NULL || s.empty() == false){
            while(root != NULL){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            if(prev != NULL && prev->val >= root->val){
                isValid = false;
                break;
            }
            prev = root;
            root = root->right;
        }
        return isValid;
    }
};

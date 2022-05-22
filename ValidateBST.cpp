//TC = O(H) , H = N in worst case
//SC = O(N)

//Using Void Function 

class Solution {
public:
    bool isValid;
    TreeNode* prev;
    bool isValidBST(TreeNode* root) {
        prev = NULL;
        isValid = true;
        inorder(root);
        return isValid;
    }
    
    void inorder(TreeNode* root){
        if(root==NULL) return;
        if(isValid)
            inorder(root->left);
        if(prev!=NULL && prev->val >= root->val)
            isValid = false;
        if(isValid)
            prev = root;   
        inorder(root->right);
    }
};

// Using Bool Function 
class Solution {
public:
    bool isValid;
    TreeNode* prev;
    bool isValidBST(TreeNode* root) {
        prev = NULL;
        return inorder(root);
    }
    
    bool inorder(TreeNode* root){
        if(root==NULL) return true;
        if(inorder(root->left) == false) return false;  
        if(prev!=NULL && prev->val >= root->val)
            return false;
        prev = root;   
        return inorder(root->right);
    }
};

//Iterative
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        stack<TreeNode*> s;
        TreeNode *prev = NULL;
        while(root!=NULL || !s.empty()){
            //inorder(root.left)
            while(root!=NULL){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            if(prev!=NULL && root->val <= prev->val)
                return false;
            prev = root;
            //inorder(root.right)
            root = root->right;
        }
        return true;
    }
};

//Range Method 
class Solution {
public:
    bool isValid;
    bool isValidBST(TreeNode* root) {
        isValid = true;
        helper(root,NULL,NULL);
        return isValid;
    }
    
    void helper(TreeNode* root, TreeNode* min, TreeNode* max){
        if(root == NULL) return;
        if(max!=NULL && root->val >= max->val) {
            isValid=false;
            return;
        }
       if(min!=NULL && root->val <= min->val) {
            isValid=false;
            return;
       }
       helper(root->left,min,root);
       if(isValid)
           helper(root->right,root,max);
    }
};

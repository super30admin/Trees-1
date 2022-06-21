// Approach 1 - 'void'
// Time Complexity - O(n) - 'n' is the number of nodes in the tree.
// Space Complexity - O(h) - 'h' is the height of the tree.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    TreeNode* prev = NULL;
    bool flag;
private:
    void inorder(TreeNode* root2){
        //base case
        if(root2 == nullptr)
            return;
        //Logic
        inorder(root2->left);

        if(prev != NULL && prev->val >= root2->val)
            flag = false;
        prev = root2;
        
        if(flag){
            inorder(root2->right); 
        }
        
    }
    public:
    bool isValidBST(TreeNode* root) {
        flag = true;
        inorder(root);
        return flag;
    }
    
};

// Approach 2 - 'bool'
class Solution {
    TreeNode* prev = NULL;
    //bool flag;
private:
    bool inorder(TreeNode* root2){
        //base case
        if(root2 == nullptr)
            return true;
        //Logic
        if(inorder(root2->left) == false)
            return false;

        if(prev != NULL && prev->val >= root2->val)
            return false;
        prev = root2;
        
        return inorder(root2->right);
        
    }
    public:
    bool isValidBST(TreeNode* root) {
        return inorder(root);;
    }
    
};

// Approach 3 - Iterative version
// Time Complexity - O(n) - Since we are iterating over 'n' nodes in the tree.
// Space Complexity - O(h) - 'h' is the height of the tree.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* prev = NULL;
        stack<TreeNode*> st;
        while(root != NULL || !st.empty()){
            while(root != NULL){
                st.push(root);
            root = root->left;
                    
            }
    
        root = st.top();
        st.pop();
        if(prev != NULL && prev->val >= root->val)
            return false;
        prev = root;
        root = root->right;
        }
        return true;
    }
};

// Approach 4 - Maintainng a 'max'-'min' state at every root and checking if the value of my root is within the state.
// Time Complexity - O(n) - Since we are iterating over 'n' nodes in the tree.
// Space Complexity - O(h) - 'h' is the height of the tree.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    private:
    bool helper(TreeNode* root, long min, long max){
        // base case
        if(root == NULL) return true;
        if(root->val <= min) return false;
        if(root->val >= max) return false;
        
        // logic
        bool left = helper(root->left, min, root->val);
        bool right = helper(root->right, root->val, max);
        return left && right;
    }
public:
    bool isValidBST(TreeNode* root) {
        return helper(root, LONG_MIN, LONG_MAX);
    }
};

// Using Nodes 'min' and 'max' instead of int.
class Solution {
    private:
    bool helper(TreeNode* root, TreeNode* min, TreeNode* max){
        // base case
        if(root == NULL) return true;
        if(min != NULL && root->val <= min->val) return false;
        if(max != NULL && root->val >= max->val) return false;
        
        // logic

        // logic
        // bool right;
        // bool left = helper(root->left, min, root);
        // if(left){
        //      right = helper(root->right, root, max);
        // }

        bool left = helper(root->left, min, root);
        bool right = helper(root->right, root, max);
        return left && right;
    }
public:
    bool isValidBST(TreeNode* root) {
        return helper(root, NULL, NULL);
    }
};
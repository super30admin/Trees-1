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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where n is the number of nodes and h is the height of the tree.
*/
class Solution {
public:
    void inorder(TreeNode *root)
    {
        if(root == NULL)
            return;
        inorder(root->left);
        //s.pop();
        cout<<root->val<<" ";
        inorder(root->right);
        //s.pop();
    }
    bool isValidBST(TreeNode* root) {
        inorder(root);
            return true;
    }
};


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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where n is the number of nodes and h is the height of the tree.
*/
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        stack<TreeNode*> s;
        while(root != NULL || s.empty() == false){
            while(root != NULL){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            cout<<root->val<<" ";
            root = root->right;
        }
        return true;
    }
};



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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where n is the number of nodes and h is the height of the tree.
*/
class Solution {
public:
    bool flag=true;
    TreeNode *prev=NULL;
    bool inorder(TreeNode * root)
    {
        if(root==NULL)
            return 0;
        inorder(root->left);
        if(prev!=NULL && prev->val>=root->val)
            flag=false;
        prev=root;
        inorder(root->right);
        return flag;
    }
    bool isValidBST(TreeNode* root) {
        return inorder(root);
    }
};


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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where n is the number of nodes and h is the height of the tree.
*/
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

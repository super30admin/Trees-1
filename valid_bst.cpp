
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(1) if stack size considered then O(n).
//1. Call recursion on the left node of the root till null condition is met
//2. Check whether the root is greater than the left node
//3. Call recursion on the right node

//Iterative solution
// Time Complexity : O(n)
// Space Complexity : O(n)
//1. Create a stack and start pushing the left nodes
//2. When null condition is met pop and check with the previous pop whether greater or not.
//3. Do the same with the right node.
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

//Recursive solution
class Solution {
public:
    int previous=-999, current=-999;
    bool isValidBST(TreeNode* root) {
        //edge case
        if(root == NULL){
            return true;
        }
        if(isValidBST(root->left)==false) return false;
        previous = current;
        current = root->val;
        //returning condition
        if(previous!=-999 && current<=previous){
                return false;
        }
        return isValidBST(root->right);

    }
};

//iterative solution
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        //edge case
        if(root == NULL){
            return true;
        }
        int previous=-999, current=-999;
        stack<TreeNode*> tree_stack;
        //iterative logic
        while(root !=NULL || !tree_stack.empty()){
            while(root !=NULL){
                tree_stack.push(root);
                root=root->left;
            }
            previous = current;
            root = tree_stack.top();
            current = root->val;
            tree_stack.pop();
            if(previous!=-999 && current<=previous){
                return false;
            }
            root=root->right;
        }
        return true;
    }
};

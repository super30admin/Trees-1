// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach: 
//1. We will do an inorder traversal of the tree and keep track of the previous node.
//2. If the current node is less than or equal to the previous node, we will set the flag to false.
//3. If the flag is false, we will return false as base case for conditional recursion to avoid traversing full tree

class Solution {
    private: 
        bool flag = true;
        TreeNode* prev = nullptr;
        void helper(TreeNode* root){
            if(root == nullptr || flag == false){
                return;
            }
            helper(root -> left);
            if(prev != nullptr && root -> val <= prev -> val){
                flag = false;
            }
            prev = root;
            helper(root -> right);
        }
    public:
        bool isValidBST(TreeNode* root) {
            helper(root);
            return flag;
        }
    };
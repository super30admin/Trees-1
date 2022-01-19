/*
Time Complexity:
O(n) as we are iterating through the tree only once
*/

/*
Space Complexity:
O(n) as we are considering the height of the stack 
*/

/*
Approach:
Recursion is given preference here over the iterative solution because of the
ease we get while coding a recursive solution in this case as compared to the later

Wer are following the inorder traversal approach and are going to the left until
we hit the NULL and then as we start moving backwards to the right direction
we have to check if the value of the previous node is smaller or bigger than 
the current nodes value. Then we keep  making recursive calls on the right
subtree to do the same process as described above.
 */

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode *prev = NULL;
        bool flag= true;
        helper(root, prev, flag);
        return flag;
    }
    
    private:
    void helper(TreeNode *root, TreeNode* &prev, bool &flag){
        //base 
        if(root == NULL) return;
        //logic
        helper(root->left, prev, flag);
        if(prev != NULL && prev->val >= root->val){
            flag = false;
        }
        prev = root;
        helper(root->right, prev, flag);
        
    }
};
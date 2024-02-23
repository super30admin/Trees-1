// 98. Validate Binary Search Tree
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
ensuring that each node's value falls within a certain range defined by its parent nodes. Specifically, checking that for each node,
its value is greater than the minimum value allowed in its left subtree and less than the maximum value allowed in its right subtree.
If any node violates this condition, then returns false; otherwise, returns true.
*/

bool isValidBST(TreeNode* root) {
    return helper(root, LONG_MIN, LONG_MAX);
}
bool helper(TreeNode* root, long min, long max)
{
    if(root == NULL) return true;

    if(root->val <= min || root->val >= max) return false;

    return helper(root->left, min, root->val) && helper(root->right, root->val, max);

}
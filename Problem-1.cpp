//O(n) + O(n) recursive stack space
//Since recursive stack space is erased post operation, shouldn't it just be O(1)? gonna ask sir
class Solution {
public:
    bool isBST(TreeNode* root, TreeNode* l, TreeNode* r) 
{ 
    // Base condition 
    if (root == NULL) 
        return true; 
  
    // if left node exists then check it has 
    // correct data or not i.e. left node's data 
    // should be less than root's data 
    if (l != NULL and root->val <= l->val) 
        return false; 
  
    // if right node exists then check it has 
    // correct data or not i.e. right node's data 
    // should be greater than root's data 
    if (r != NULL and root->val >= r->val) 
        return false; 
  
    // check recursively for every node. 
    return isBST(root->left, l, root) and 
           isBST(root->right, root, r); 
} 
    bool isValidBST(TreeNode* root) {
        TreeNode *l = NULL;
        TreeNode *r=NULL;
        return isBST(root,l,r);
    }
};

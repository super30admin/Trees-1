// TC:O(N),SC:O(H)
// Here taking isvalid and prev as global as it is to be passed to next node
// using in order traversal
// Another approach is to pass limits to each node

class Solution {
public:
    TreeNode* prev;
    bool isValid=true;

    bool isValidBST(TreeNode* root) {
      
        BST(root);
        return isValid;
    }

    void BST(TreeNode* root)
    {
        if(root==nullptr) 
        return;

        BST(root->left);

        if(prev && prev->val>=root->val)
        {
            isValid=false;
            return;
        }

        prev=root;
        BST(root->right);
    }
};




// Approach-2

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        // here passing NULL instead of INT_MIN and INT_MAX as root value ranges includes these botj
        return isBST(root, NULL, NULL);
    }
    
    bool isBST(TreeNode* root, TreeNode* minNode, TreeNode* maxNode) {
        if (!root) return true;
        
        if (minNode && root->val <= minNode->val) return false;
        if (maxNode && root->val >= maxNode->val) return false;
        
        return isBST(root->left, minNode, root) && isBST(root->right, root, maxNode);
    }
};
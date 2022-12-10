class Solution {
public:
    TreeNode *prev ;
    bool isBST = true ; 
    bool isValidBST(TreeNode* root) {
        if(root == NULL) return true ; 
        
        inorder_traversal(root) ; 
         
        return isBST ; 
    }
    
    
  public:
     void inorder_traversal(TreeNode*root){
        if(root == NULL){
            return ; 
        }
         
        inorder_traversal(root -> left)  ; 
        
        if(prev != NULL && prev -> val >= root -> val){
            isBST = false ; 
            
            return ; 
        }
        
        prev = root ; 
        
        inorder_traversal(root -> right) ;
        
    }
    
};

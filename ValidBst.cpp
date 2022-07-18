//TC-O(N)
//SC-O(N)
  bool isValidBST(TreeNode* root) {
        return checker(root,NULL,NULL);
    }
    bool checker(TreeNode* root,TreeNode* max,TreeNode* min){
        if(!root)return true;
         if(max&&root->val>=max->val)return false;
         if(min&&root->val<=min->val)return false;
           bool leftsubtrees=checker(root->left,root,min);
           bool rightsubtrees=checker(root->right,max,root);
        
        return leftsubtrees&&rightsubtrees;
    }
};
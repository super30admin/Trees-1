// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution{
    public:
            bool svalid=true;
            TreeNode *prev=nullptr;
            void valid(TreeNode* root)
            {
                if(root==nullptr)
                {
                    return;
                }
                valid(root->left);
                if(prev!=nullptr && (prev->val)>=(root->val))
                {
                    svalid=false;
                    return;
                }
                else
                {
                prev=root;
                valid(root->right);
                }
                
                
            }
            bool isValidBST(TreeNode* root) 
            {
               
                if (root==nullptr)
                {
                    return true;
                }
                valid(root);
                return svalid;
                
            }
};

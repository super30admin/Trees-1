//Time O(n)
 //Space O(1)
 //Leetcode Yes
 //Issue seen none
class Solution {
public:
    bool dfs(TreeNode* root, long int min,long int max){
        if(!root) return true;
        if(root->val <= min || root->val >= max){
            return false;
        }
        return(dfs(root->left, min, root->val) && dfs(root->right, root->val, max));
    }
    
    bool isValidBST(TreeNode* root) {
        if(!root) return true;
        long int min = LONG_MIN;
        long int max = LONG_MAX;

        return dfs(root, min, max);
    }
};

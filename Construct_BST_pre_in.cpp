 //Time O(n)
 //Space O(n)
 //Leetcode Yes
 //issue seen: none
class Solution {
public:
    int preIdx =0;
    unordered_map<int,int> mp;
    TreeNode* dfs(vector<int>& preorder, int start, int end){
        if(start > end){
            return NULL;
        }

        TreeNode* node = new TreeNode();
        node->val = preorder[preIdx];
        preIdx++;
        int split_idx = mp[node->val];
        
        node->left = dfs(preorder, start, split_idx-1);
        node->right = dfs(preorder, split_idx+1, end);
        
        return node;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {

        for(int i =0; i<inorder.size(); i++){
            mp[inorder[i]] = i;
        }

        return dfs(preorder, 0, inorder.size()-1);
        
    }
};

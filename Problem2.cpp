// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    //O(n) time complexity
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int st, int end, int &idx, map<int, int>& m){
        if(st>end || idx==preorder.size()) return NULL;
        
        TreeNode* root = new TreeNode(preorder[idx]);
        idx++;
        
        int root_idx = m[root->val];
        root->left= helper(preorder, inorder, st, root_idx-1, idx,m);
        root->right = helper(preorder, inorder, root_idx+1, end, idx, m);
        
        return root;
        
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //poplulate the map with inorder elements
        map<int, int> m;
        for(int i=0; i<inorder.size(); i++){
            if(m.find(inorder[i])==m.end())
                m[inorder[i]]=i;
        }
        int idx=0;
        
       return helper(preorder, inorder,0, inorder.size()-1, idx,m );
    }
};

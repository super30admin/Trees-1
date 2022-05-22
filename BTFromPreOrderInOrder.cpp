class Solution {
public:
    TreeNode* build(vector<int>& pre, vector<int>& in, int preIndex,  int is, int ie){
        if(preIndex>=pre.size() || is>ie)
            return NULL;
        TreeNode * root = new TreeNode(pre[preIndex]);
        int inIndex=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root->val){
                inIndex=i;
                break;
            }
        }
        root->left=build(pre, in, preIndex + 1, is, inIndex-1);
        root->right=build(pre, in, preIndex + inIndex - is + 1, inIndex+1, ie);
        return root;
    }
    TreeNode* buildTree(vector<int>& pre, vector<int>& in) {
        return build(pre, in, 0, 0, in.size()-1);
    }
};

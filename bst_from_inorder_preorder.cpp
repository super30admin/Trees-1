class Solution {
public:
    TreeNode* buildTree(vector<int> &preorder, vector<int> &inorder) {
        if(preorder.size() == 0 || inorder.size() == 0) return NULL;
        int root_val = preorder[0] ;
        TreeNode *root = new TreeNode(root_val);
        //cout << root_val ;
        int root_index ;
        int size = inorder.size() ;
        // finding root node in inorder array
        for(int i = 0 ; i < inorder.size() ; i ++){
            if(inorder[i] == root_val){
                root_index = i ;
                break;
            }
        }
        //cout << root_index ;
        // found root index , now create sub - arrays for left and right part of the tree
        vector <int> inorder_left ;
        vector <int> inorder_right;
        vector <int> preorder_left ;
        vector <int> preorder_right;
        for(int i = 0 ; i < root_index ; i++){
            inorder_left.push_back(inorder[i]) ;
            // cout << inorder_left[i] ;
        }
        for(int j = root_index + 1 ; j < inorder.size() ; j++){
            inorder_right.push_back(inorder[j]) ;
            // cout << inorder_right[j] ;
        }
        for(int i = 1 ; i < root_index + 1  ; i++){
            preorder_left.push_back(preorder[i]) ;
            //cout << i ;
        }
        for(int i = root_index + 1 ; i < preorder.size() ; i++){
            preorder_right.push_back(preorder[i]) ;
            //cout << i ;
        }
        root -> left = buildTree(preorder_left,inorder_left) ;
        root -> right = buildTree(preorder_right,inorder_right) ;
        return root;
     }
};

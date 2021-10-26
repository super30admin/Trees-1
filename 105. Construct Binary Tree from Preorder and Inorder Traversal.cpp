/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
/*
Time Complexity = O(N*N)
Space Complexity = O(N*N)
where N is the number of elements in the Inorder vector.
*/
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size()==0)
            return NULL;
        int index, i;
        TreeNode* root = new TreeNode(preorder[0]);
        for(i=0;i<inorder.size();i++)
        {
            if(preorder[0]==inorder[i])
            {
                index=i;
                break;
            }
        }
        /*vector <int> preorderLeft(3000),preorderRight(3000),inorderLeft(3000),inorderRight(3000);
        
        copy(inorder.begin(),inorder.begin()+index-1,inorderLeft.begin());
        
        copy(inorder.begin()+index+1,inorder.end(),inorderRight.begin());
        
        copy(preorder.begin()+1,preorder.begin()+index,preorderLeft.begin());
        
        copy(preorder.begin()+index+1,preorder.end(),preorderRight.begin());*/
        
        vector<int> inorderLeft, inorderRight, preorderLeft, preorderRight;
        for(int i=0; i<index; i++){
            inorderLeft.push_back(inorder[i]);
        }
        for(int i=index+1; i<inorder.size(); i++){
            inorderRight.push_back(inorder[i]);
        }
        for(int i=1; i<index+1; i++){
            preorderLeft.push_back(preorder[i]);
        }
        for(int i=index+1; i<preorder.size(); i++){
            preorderRight.push_back(preorder[i]);
        }
        
        root->left = buildTree(preorderLeft,inorderLeft);
        root->right = buildTree(preorderRight,inorderRight);
        return root;
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
/*
Time Complexity = O(N)
Space Complexity = O(N)
where N is the number of elements in the Inorder vector.
*/
class Solution {
public:
    map<int, int> m;
    int idx=0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size() == 0){
            return NULL;
        }
        for(int i=0; i<inorder.size(); i++){
            m[inorder[i]] = i;
        }
        return helper(preorder, inorder, 0, inorder.size()-1);
    }
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end){
        if(start>end)
            return NULL;
        

        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode* root = new TreeNode(rootVal);
        int rootIdx = m[rootVal];
        root->left = helper(preorder, inorder, start, rootIdx-1);
        root->right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
};

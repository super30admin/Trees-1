


// Approach-1

// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// we store the inorder indices in the map.
// we maintain a pidx as global variable to cover all the indices in the preorder array.
// keep in mind that we create the Nodes 
// only using the preorder array and we use inorder array for linking purposes as to what goes root left and what goes root right.
// using a helper function passing inorder array and indices of inorder array, we are able to solve it.



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
class Solution {
public:
    int pidx = 0;
    unordered_map<int,int>mp;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size()==0 || inorder.size()==0)
        {
             return NULL;
        }
        for(int i =0; i<inorder.size();i++)
        {
            mp[inorder[i]]=i;
        }
        
        return f(preorder, 0, preorder.size()-1);
    }
    TreeNode* f(vector<int>&preorder,int lo,int hi)
    {
        if(lo>hi) return NULL;
        int rootVal = preorder[pidx++];
        TreeNode* root = new TreeNode(rootVal);
        int id = mp[rootVal];
        root->left  = f(preorder, lo, id-1);
        root->right = f(preorder, id+1,hi);
        return root;
    }
};

// Approach-2

// Time Complexity :  O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// we create node for root and then modify the given preorder array and inorder array.
// we use inorder array to identify LEFT and Right of root.

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
class Solution {
public:
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size()==0 || preorder.size()==0)
        {
            return NULL;
        }
        int rootVal = preorder[0];
        TreeNode* root = new TreeNode(rootVal);
        int idx = -1;
        for(int i = 0;i<preorder.size();i++)
        {
            if(inorder[i]==rootVal){
                idx = i;
                break;
            }
        }
        vector<int>preorderLeft(preorder.begin()+1,preorder.begin()+idx+1);
        vector<int>preorderRight(preorder.begin()+idx+1,preorder.end());
        vector<int>inorderLeft(inorder.begin(), inorder.begin() + idx);
        vector<int>inorderRight(inorder.begin() + idx+1,inorder.end());
        
        root->left = buildTree(preorderLeft,inorderLeft);
        root->right = buildTree(preorderRight, inorderRight);
        return root;
    }
};
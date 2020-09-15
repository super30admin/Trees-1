// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
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

//Hashmapsolution
// Time Complexity : O(n)
// Space Complexity : O(n).
//1. Find build hashmap for the inorder traversal array
//2. Find root using hashmap and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part
class Solution {
public:
    unordered_map<int, int> tree_map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //edge case
        if(preorder.size()==0 || inorder.size()==0){
            return NULL;
        }
        for(int i=0; i<inorder.size(); i++){
            tree_map[inorder[i]] = i;
        }
        return helper(preorder, 0, inorder, 0, inorder.size()-1);
    }
private:
    TreeNode* helper(vector<int>& preorder,int pre_index, vector<int>&  inorder,int in_start,int in_end){
        //return condition
        if(in_start>in_end){
            return NULL;
        }
        TreeNode* root = new TreeNode (preorder[pre_index]);
        int i= tree_map[root->val];
        root->left = helper(preorder, pre_index+1, inorder, in_start , i-1);
        root->right = helper(preorder, pre_index+i-in_start+1, inorder, i+1, in_end );
        return root;
    }
    
};



// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :

//Itss very very tricky

// Your code here along with comments explaining your approach
//1. The pre-order traversal takes into account root first.
//2. The traversal covers left side first and then the right side.
//3. So increment pre_idx in the pre_order array for each element traversed on the left side. this will lead to correct pre_idx for the right side. 


class Solution {
public:
    TreeNode* root;
    int pre_idx=0;
     unordered_map <int, int> my_map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //edge
        if(preorder.size()==0 && inorder.size()==0){
            return NULL;
        }
        //recurse
       for(int i=0; i<inorder.size();i++){
           my_map[inorder[i]] = i;
       }
        root = dfs( preorder, 0, inorder.size());
        return root;
    }
    
    TreeNode*  dfs(vector<int>& preorder, int in_left, int in_right){
        //return
        if(in_left==in_right){
           // cout<<preorder[pre_idx]<<" "<<pre_idx<<endl;
            return NULL;
        }
        //logic
        TreeNode* temp = new TreeNode (preorder[pre_idx]);
       // cout<<preorder[pre_idx]<<" "<<pre_idx<<endl;
        int root_index = my_map[preorder[pre_idx]];
        pre_idx++;
        temp->left = dfs( preorder,  in_left, root_index);
        
        temp->right = dfs( preorder, root_index+1, in_right);
        
        return temp;
    }
};



//Recursive solution
// Time Complexity : O(n^2)
// Space Complexity : O(n).
//1. Find root and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        //edge case
        if(preorder.size()==0 || inorder.size()==0){
            return NULL;
        }
        return helper(preorder, 0, inorder, 0, inorder.size()-1);
    }
private:
    TreeNode* helper(vector<int>& preorder,int pre_index, vector<int>&  inorder,int in_start,int in_end){
        //return condition
        if(in_start>in_end){
            return NULL;
        }
        TreeNode* root = new TreeNode (preorder[pre_index]);
        int i;
        for(i=0; i<inorder.size(); i++ ){
            if(inorder[i]==root->val) break;
        }
        root->left = helper(preorder, pre_index+1, inorder, in_start , i-1);
        root->right = helper(preorder, pre_index+i-in_start+1, inorder, i+1, in_end );
        return root;
    }
    
};

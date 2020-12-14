// ## Problem 2

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Given preorder and inorder traversal of a tree, construct the binary tree

//Did this code run on leetcode :Yes


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

//idea- optimization using hash map
//TC - O(n) as hash map search is O(1), SC - O(n) for nodes in hash map
class Solution {
public:
     unordered_map <int, int> m1; //global
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        if( preorder.size() == 0 || inorder.size()==0){
            return NULL;
        }
        
        
        for(int i=0; i< inorder.size(); i++){
            
            m1[inorder[i]] = i;
        }
        
        int inindex_s=  0;
        int inindex_e= inorder.size()-1;
        int idx = 0;
        return helper( preorder,inindex_s, inindex_e, idx);
       
    }
    
    TreeNode* helper(vector<int>& preorder, int inindex_s, int inindex_e, int &idx){
   
        
        if ( inindex_s > inindex_e)
        {
            return NULL;
        } 
  
        int rootVal = preorder[idx];
        TreeNode* root= new TreeNode( rootVal);
        idx++;
        int rootIndx = m1[rootVal];
        
        root->left = helper( preorder,  inindex_s, rootIndx-1 ,idx );
        root->right = helper( preorder, rootIndx+1 , inindex_e, idx);
      
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
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        if( preorder.size() == 0 || inorder.size()==0){
            return NULL;
        }
        int preindex_s= 0;
        int preindex_e= preorder.size()-1;
        int inindex_s=  0;
        int inindex_e= inorder.size()-1;
        return helper( preorder, inorder, preindex_s, preindex_e, inindex_s, inindex_e);
       
    }
    
    
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int preindex_s, int preindex_e, int inindex_s, int inindex_e){
   
        
              
        if( preindex_s > preorder.size()-1 || preindex_e > preorder.size()-1  || inindex_s >inorder.size()-1 || inindex_e > inorder.size()-1){
            return NULL;
        }
        if ( preindex_s > preindex_e || inindex_s > inindex_e)
        {
            return NULL;
        } 
  
        int rootVal = preorder[preindex_s];
        TreeNode* root= new TreeNode( rootVal);
        int idx= -1;
        
        for(int i=inindex_s; i<= inindex_e; i++){
            if(inorder[i]== rootVal){
                idx= i-inindex_s ;
                break;
            }
        }
        cout<< idx <<endl;
        
        root->left = helper( preorder, inorder, preindex_s+1, preindex_s+ idx, inindex_s, inindex_s + idx-1 );
        root->right = helper( preorder, inorder, preindex_s + idx+1, preindex_e, inindex_s + idx +1 , inindex_e);
      
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
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        if( preorder.size() == 0 || inorder.size()==0){
            return NULL;
        }
        int preindex_s= 0;
        int preindex_e= preorder.size()-1;
        int inindex_s=  0;
        int inindex_e= inorder.size()-1;
        return helper( preorder, inorder, preindex_s, preindex_e, inindex_s, inindex_e);
       
    }
    
    
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int preindex_s, int preindex_e, int inindex_s, int inindex_e){
   
        
              
        if( preindex_s > preorder.size()-1 || preindex_e > preorder.size()-1  || inindex_s >inorder.size()-1 || inindex_e > inorder.size()-1){
            return NULL;
        }
        if ( preindex_s > preindex_e || inindex_s > inindex_e)
        {
            return NULL;
        } 
        
          cout<< preindex_s<< preindex_e <<" preorder" <<endl;
        cout<< inindex_s << inindex_e << "inorder" <<endl;
      
        int rootVal = preorder[preindex_s];
        TreeNode* root= new TreeNode( rootVal);
        int idx= -1;
        
        for(int i=inindex_s; i<= inindex_e; i++){
            if(inorder[i]== rootVal){
                idx= i;
                break;
            }
        }
        cout<< idx <<endl;
//         vector<int> preLeft(idx); 
//         copy( preorder.begin()+1, preorder.begin()+idx, preLeft.begin());
        
//         vector<int> preRight(preorder.size()- idx);
//         copy( preorder.begin()+idx, preorder.end(), preRight.begin());
        
        root->left = helper( preorder, inorder, preindex_s+1, preindex_s+ idx- inindex_s, inindex_s, inindex_s + idx-1 - inindex_s);
        root->right = helper( preorder, inorder, preindex_s + idx+1 -inindex_s, preindex_e, inindex_s + idx +1 -inindex_s , inindex_e);
      
        return root;
    
    }
    
};
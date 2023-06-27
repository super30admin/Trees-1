// Time Complexity: O(n)
// Space Complexity: O(n) + size of recursive stack
 
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
        map<int,int> inorder_map; 

        for(int i = 0; i < inorder.size(); i++) {
            inorder_map[inorder[i]] = i; 
        }

        TreeNode* head = buildSubTree(preorder, 0, inorder_map, 0, inorder.size()-1);

        return head; 
    }


    TreeNode* buildSubTree(vector<int>& preorder, int preorder_pos, map<int,int>& inorder_map, int start, int end) {
        if(end < start) return nullptr;
        

        int inorder_index = inorder_map[preorder[preorder_pos]]; // Find the index of the root of the current tree

        //left subtreenodes are from start to inorder_index-1
        //right subtreenodes are from inorder_index+1 to end

        //preorder_pos for leftsubtree nodes is just preorder_pos+1; 
        //preorder_pos for rightsubtreenodes is preorder_pos+(number of left subtreenodes)

        int nLSTN = inorder_index - start;

        int nextPreorder_pos_left = min(preorder_pos +1 , (int)preorder.size()-1);
        int nextPreorder_pos_right = min(preorder_pos + nLSTN + 1, (int)preorder.size()-1);


        TreeNode* leftsubTree =  buildSubTree(preorder, nextPreorder_pos_left, inorder_map, start, inorder_index-1);
        TreeNode* rightsubTree = buildSubTree(preorder, nextPreorder_pos_right, inorder_map, inorder_index+1, end);

        TreeNode* node = new TreeNode(preorder[preorder_pos]);

        node->left = leftsubTree; 
        node->right = rightsubTree; 

        return node; 

    }
};
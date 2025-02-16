// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will create a hashmap to store the index of each element in the inorder array.
//2. Root will be the first element in preorder
//3. We will find the index of the root in the inorder array and divide the inorder array into left and right subtrees.
//4. We will recursively build the left and right subtrees.

class Solution {
    private: 
        unordered_map<int, int> map;
        int preorderIndex = 0; 
        TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int InorderStart, int InorderEnd){
            //base condition
            if(InorderStart > InorderEnd){return nullptr;}
    
            int rootVal = preorder[preorderIndex];
            TreeNode* root = new TreeNode(rootVal);
            preorderIndex++;
    
            int rootIndexInInorder = map[rootVal];
            
            //left subtree
            root -> left = helper(preorder, inorder, InorderStart, rootIndexInInorder - 1);
            //right subtree
            root -> right = helper(preorder, inorder, rootIndexInInorder + 1, InorderEnd);
    
            return root; 
        }
    public:
        TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
            for(int i = 0; i < inorder.size(); i++){
                map[inorder[i]] = i;
            }
            return helper(preorder, inorder, 0, inorder.size() - 1);
        }
    };
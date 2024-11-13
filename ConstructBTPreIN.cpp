//To construct a binary tree from inorder and preorder traversal
//[40,20,50,10,60,30] - inorder
//[10,20,40,50,30,60] - preorder

// now where to begin - as the preorder -> root->left-right -> so we know the 10 is the main root
// one thing to notice is the order of preorder is should be the order of the tree if we create
// tree in preorder manner

// but one challenage is how many nodes will be allocated to left branch and how many to the right
// lets say we do the preorder with a simple recursion adding each value with it than if we follow
// preorder approach root - left -right , all the value will be stored into the left branch up until
// it reaches the base condition , to avoid that we can use the information from the inorder array
// first of the preorder will be root , so 10 in inorder should have all the elements on the left 
// of left branch [40,20,50] , if we use two pointers and update the pointers for the left part with
// iterating each element from preorder we can find at each ele of preorder how many are in left and
// how many are in right branch

// so take 10 as root -> find the index 10 in inorder allocate [0,index-1] for left branch [index+1 , end] right
// take 20 as root -> find index 20 in inorder allocate [0,0],to left and [2,2] right
// take 40 ad root -> index 40 in inorder [0,-1] left ,[1,0] right -> which wont go furhter
// get out of 40, 
//  goes 20s right -> take [50] in order [2,1] [3,2]->again invalid
// get out of 50
// get out of 20
// get out of 10s left , goest to 10 right



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
    int index = 0;
private:
    TreeNode* helper(vector<int> &preorder,unordered_map<int,int>&inTracker, int left ,int right)
    {
        // to traverse through each element in recursive manner
        if(left > right)
            return NULL;
        
        // add the node
        TreeNode *new_node = new TreeNode(preorder[index++]);
        //to add the node to left
        new_node->left = helper(preorder,inTracker,left,inTracker[new_node->val]-1);

        //to add the node to right
        new_node->right = helper(preorder,inTracker,inTracker[new_node->val]+1,right);

        return new_node;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int>inTracker;
        for(int i = 0;i<inorder.size();i++)
        {
            inTracker[inorder[i]] = i;
        }
        return helper(preorder,inTracker,0,preorder.size()-1);
    }
};

//Time complexity O(N)
// Space complexity O(M) + O(N)/O(log N) O(M) = hashmap, N = for recursive stack worst N and avg log N
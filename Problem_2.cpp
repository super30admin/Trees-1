/*
Time Complexity:
O(n) as we are storing values of inorder in the hash map. After that
eachg recursive call goes only once to each node. We have n nodes
so n.O(1) is O(n). Overall time complexityw ill be O(n)
*/

/*
Space Complexity:
We are creating a hash map wwhich gives us O(n). Then we are adding n nodes
to the tree. So overall, considering the worst case the space complexity will
be O(n)
*/

/*
Approach:
Recursion is used in this solution.

We cannot create a tree with only one of the preorder or inorder arrays as we cannot be 
able to preddict which is root and which are child with only one of these two arrays.
So we use both of them. We know in case of preorder the first element is root. So
we look for the the same root value in the inorder. The index where it is found in inorder
acts as a pivot and divides the array in two parts i.e. left subtree and right subtree.

To get the value of the left child we do a recursive call with two pointers. One start from
the start of the inorder array and the other pointing to the element just before where the
root value was found in the inorder array. We do the same
to get the right child but the start and end pointers are pointing the element
next to the root element and the last element respectively*/

//The code ran perfectly on leetcode


class Solution {
    unordered_map <int, int> store;
    int rootIdx;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i< inorder.size(); i++){
            store[inorder[i]] = i;                                       
        }
        rootIdx = 0;
        return helper(preorder, inorder, 0, preorder.size() - 1);
    }
    
    private:
    TreeNode *helper(vector<int>& preorder, vector<int>& inorder, int start, int end){
        if(start>end) return NULL;
        int rootVal = preorder[rootIdx++];
        int srchIdx = store[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        //base
        
        //logic
        root->left = helper(preorder, inorder, start, srchIdx -1);
        root->right = helper(preorder, inorder, srchIdx + 1, end);
        return root;
    }
};
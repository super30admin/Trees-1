// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Build a hashmap of the inorder array for fast lookups and pass it by reference to the recursion, use the preorder array to find the next root
// When we build the left subtree, the start index remains the same as the parent start index, the end becomes rootIdx - 1
// For the right subtree, the start index becomes rootIdx + 1 and the end index is the same as the end index of the parent

// Your code here along with comments explaining your approach

class Solution {
private:
    // inMap = hashmap of inorder array, idx = root index from the preorder array, start = start index in inorder array, end = end index in inorder array
    TreeNode* helper(vector<int>& preorder, unordered_map<int, int>& inMap, int* idx, int start, int end) {
        // base case :
        if(start > end) return nullptr;

        // logic:
        int rootVal = preorder[idx];
        int rootIdx = inMap[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        (*idx)++;

        root->left = helper(preorder, inMap, idx, start, rootIdx - 1);
        root->right = helper(preorder, inMap, idx, rootIdx + 1, end);

        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int idx = 0;
        unordered_map<int, int> inMap;
        for(int i=0; i<inorder.size(); i++) {
            inMap[inorder[i]] = i;
        }
        TreeNode* root = helper(preorder, inMap, &idx, 0, inorder.size() - 1);

        return root;
    }
};
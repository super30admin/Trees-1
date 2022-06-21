// Brute Force Solution
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0)
            return NULL;
        int currRoot = preorder[0];
        int idx = -1;
        for(int i = 0; i < preorder.size(); i++){
            if(inorder[i] == currRoot)
                {
                idx = i;
                break;
                }
        }
        
        TreeNode* root = new TreeNode(currRoot);
        vector<int> inLeft, inRight, preLeft, preRight;
        vector<int>::iterator itr;
        copy(inorder.begin(), inorder.begin()+idx, inserter(inLeft, itr));
        copy(inorder.begin()+idx+1, inorder.end(), inserter(inRight, itr));
        copy(preorder.begin()+1, preorder.begin()+inLeft.size()+1, inserter(preLeft, itr));
        copy(preorder.begin()+inLeft.size()+1, preorder.end(), inserter(preRight, itr));
        
        root->left = buildTree(preLeft,inLeft);
        root->right = buildTree(preRight, inRight);
        return root;
    }
};


// Approach 2 - 
// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    unordered_map<int, int> map;
    int idx = 0;
    private:
    TreeNode* helper(vector<int>& arr, int start, int end){
        int m = arr.size();
        if(start > end)
            return NULL;
        
        int currRoot = arr[idx];
        idx++;
        int currRootIdx = map[currRoot];
        
        TreeNode* root = new TreeNode(currRoot);
        root->left = helper(arr, start, currRootIdx-1);
        root->right = helper(arr, currRootIdx+1, end);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++)
            map[inorder[i]] = i;
        
        return helper(preorder, 0, preorder.size()-1);
    }
};
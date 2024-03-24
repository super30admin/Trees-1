// {Approach 1}
// Time Complexity : O(N) ...... N is toltal number of elements in tree
// Space Complexity : O(N) 
//
// {Approach 2, 3, 4}
// Time Complexity : O(N)
// Space Complexity : O(1); if we consider stack used for recursion --> O(hight of tree)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/validate-binary-search-tree/description/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search tree
*/


/*
Approach 1 : Using extra space

Tree is traversed in inOrder way and each visited node is stored in an array.
As per binary search tree properties, this array should be sorted in asceding order.
If any element is less than previous element in this array, that means this is not a binary
search tree. 
*/


class Solution {
    vector<int>arr;
public:
    bool isValidBST(TreeNode* root) {
        if(root == nullptr) return false;
        inOrderTraverse(root);
        if(arr.size() == 1) return true;

        for(int i=1; i<arr.size(); i++){
            if(arr[i] <= arr[i-1]) return false;
        }
        return true;
    }

    void inOrderTraverse(TreeNode* root){
        if(root == nullptr) return;

        inOrderTraverse(root->left);  // Visit left child
        arr.push_back(root->val);     // Visit root
        inOrderTraverse(root->right); // Visit right child
    }
};



/*
Approach 2 : Using constant space

prev pointer is used to keep track of previously visited node.
comapring root-> val with prev->val is nothing but comparing arr[i] with arr[i-1] in 
approach 1.

*/

class Solution {
    bool flag = true;
    TreeNode* prev = nullptr;
public:
    bool isValidBST(TreeNode* root) {
        if(root == nullptr) return false;
        inOrderTraverse(root);
        return flag;
    }

    void inOrderTraverse(TreeNode* root){
        if(root == nullptr || flag == false) return;  // do not traverse further if 
                                                    // flag is set to false in between

        inOrderTraverse(root->left);
        if(prev != nullptr && prev->val >= root->val) {
            flag = false;
            return;
        }
        prev = root;
        inOrderTraverse(root->right);
    }
};


/*
Approach 3 : Using constant space

This approach is similar to approach 2.
But instead of using extra space 'flag', helper function itself is returning
boolean value.
*/


class Solution {
    TreeNode* prev = nullptr;
public:
    bool isValidBST(TreeNode* root) {
        if(root == nullptr) return false;
        return inOrderTraverse(root);
    }

    bool inOrderTraverse(TreeNode* root){
        if(root == nullptr) return true;

        bool left = inOrderTraverse(root->left);
        if(prev != nullptr && prev->val >= root->val) {
            return false;
        }
        prev = root;
        if(!left) { return false; }
        bool right = inOrderTraverse(root->right);
        return left && right;
    }
};


/*
Approach 4 : Comparing at each node

min and max limit is passed while traversing the tree and at each node
it is checked in node value is less then min value and more than max value.

Refer video - 

*/


class Solution {
    bool flag = true;
public:
    bool isValidBST(TreeNode* root) {
        long min = INT_MIN;
        long max = INT_MAX;
        inOrderTraverse(root, min-1, max+1);
        return flag;
    }

    void inOrderTraverse(TreeNode* root, long min, long max){
        if(root == nullptr || !flag) return;

        if(root->val <= min) {
            flag = false;
            return;
        }

        if(root->val >= max) {
            flag = false;
            return;
        }
        inOrderTraverse(root->left, min, root->val);
        inOrderTraverse(root->right, root->val, max);

    }
};
/* Problem Statement:
Verified on leetcode

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


 *
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>


/**
 * Definition for a binary tree node.
 */
 struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };


bool isValidBSTHelper(struct TreeNode *root, int64_t min_val, int64_t max_val) {
    bool is_left_tree_valid = false;
    
    /* Empty tree is a valid BST */
    if (root == NULL) {
        return true;
    }
    /* validations */
    if ((root->val < min_val || root->val > max_val)) {
        return false;
    }
    /* if left tree return false, no point checking the right tree !! */
    is_left_tree_valid = isValidBSTHelper(root->left, min_val, ((int64_t)root->val - 1));
    if (is_left_tree_valid) {
        return isValidBSTHelper(root->right,((int64_t)root->val + 1), max_val);
    } else {
        return is_left_tree_valid;
    }
    
}
bool isValidBST(struct TreeNode* root){
    /* For each node, we have to see if it is violating the min and max value allowed for that node, if not
     * then we keep on checking it, unless we find any issue in binary search tree. */
    return isValidBSTHelper(root, INT_MIN, INT_MAX);
}




int main(int argc, char *argv[]) {
    struct TreeNode t1;
    struct TreeNode t2;
    struct TreeNode t3;
    struct TreeNode t4;

    t1.val = 5; t1.left = &t2; t1.right = &t3;
    t2.val = 7; t2.left = NULL; t2.right = &t4;
    t3.val = 10; t3.left= NULL; t3.right = NULL;
    t4.val = 14; t4.left = NULL; t4.right = NULL;

    printf("is valid BST ? : %d\n", isValidBST(&t1));
    return 0;
}



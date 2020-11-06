/* Problem Statement:
Verified on leetcode

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7



 *
 * Time Complexity : O(n) 
 * Space Complexity : O(n)
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

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    struct TreeNode *root = NULL;
    int *preorder_left_arr = NULL;
    int *inorder_left_arr = NULL;
    int *preorder_right_arr = NULL;
    int *inorder_right_arr = NULL;
    
    int idx = 0, idx2 = 0;

    /* Validations for input sizes of preorder and inorder */
    if ((!preorderSize) || (!inorderSize)) {
        return NULL;
    }
    /* Allocation for new element */
    root = (struct TreeNode *)calloc(1, sizeof(struct TreeNode));
    if (!root) {
        return NULL;
    }
    root->val = preorder[0];
    
    /* Search for root in the inorder traversal */
    for (idx = 0; idx < inorderSize; idx++) {
        
        if (inorder[idx] == preorder[0]) {
            break;
        }
    }
    /* No element found which means just return NULL */
    if (idx == inorderSize) {
        return NULL;      
    } /* The only element present in preorder array, so just return it */
    else if ((idx == 0) && (preorderSize == 1)) {
        return root;
    }
    /* Left side of subtree input for preorder and inorder inputs */
    if ((idx > 0)) {
        preorder_left_arr = (int *)malloc(sizeof(int) * idx);
        inorder_left_arr  = (int *)malloc(sizeof(int) * idx);

        for (idx2 = 1; idx2 <= idx;idx2++) {
            preorder_left_arr[idx2 - 1] = preorder[idx2];
        }
        for (idx2 = 0; idx2 < idx;idx2++) {
            inorder_left_arr[idx2 ] = inorder[idx2];
        }    
    
    }
    /* Right Side of the subtree input for preorder and inorder inputs */
    if ((inorderSize - (idx+1)) != 0) {
        
        preorder_right_arr = (int *)malloc(sizeof(int) * (inorderSize - (idx + 1)));
        inorder_right_arr  = (int *)malloc(sizeof(int) * (inorderSize - (idx + 1))); 
        
        for (idx2 = idx + 1; idx2 < inorderSize;idx2++) {
            preorder_right_arr[idx2 - (idx + 1)] = preorder[idx2];
        }
        for (idx2 = 0; idx2 < (inorderSize - (idx+1));idx2++) {
            inorder_right_arr[idx2] = inorder[idx2 + idx + 1];
        }    

    }
    
    root->left = buildTree(preorder_left_arr, idx, inorder_left_arr, idx);
    root->right = buildTree(preorder_right_arr,(inorderSize - (idx+1)), inorder_right_arr, (inorderSize - (idx+1)));
    
    /* Free memory */
    free(preorder_left_arr);
    free(preorder_right_arr);
    free(inorder_right_arr);
    free(inorder_left_arr); 
    return root;

}

void inorder_traversal(struct TreeNode *root) {

  if (!root) {
    return;
  }
  inorder_traversal(root->left);
  printf("%d ", root->val);
  inorder_traversal(root->right);
}

int main(int argc, char *argv[]) {

    struct TreeNode *root = NULL;
    int preorder[5] = {3,9,20,15,7};
    int inorder[5] = {9,3,15,20,7};

    root = buildTree(preorder,5,inorder,5);
    printf("\n");
    inorder_traversal(root);
    printf("\n");
    return 0;
}



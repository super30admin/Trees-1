"""
Time Complexity : O(n) where n is the number of elements in the tree. In the worst case(Like a valid BST) we have to traverse through all the elements of the tree
Space Complexity : O(h) where h is the height of the tree. At any point of time recursive stack will contain elements equal to height of the tree
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
Inorder traversal of binary search tree gives elements of tree in ascending (left->root->right) or descending (right->root->left) order.
If inorder traversal gives the elements in ascending order then it is a valid BST otherwise it is not a valid BST.

This problem can be solve using three approaches:
1. Recursion (helper function can be void or boolean)
2. Iterative
3. Limit Approach

The following code is written with Limit Approach
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
        
    def helper(self, root, minLimit, maxLimit):
        #base
        if root == None:
            return 

        #Logic
        if minLimit != None and root.val <= minLimit:
            self.flag = False
        
        if maxLimit != None and root.val >= maxLimit:
            self.flag = False
        
        self.helper(root.left, minLimit, root.val)
        self.helper(root.right, root.val, maxLimit)
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root, None, None)
        return self.flag
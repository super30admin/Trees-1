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

The following code is written with iterative approach
In the iterative approach we need to declare our own stack and need to perfrom pop operation and variable mapping after pop by ourselves. Hence if variable count pushed to the stack is more recursive approach is more convinient as the mapping takes place automatically under the hood.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None
        while(root != None or len(stack) > 0):
            #Left Traversal
            while(root != None): 
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
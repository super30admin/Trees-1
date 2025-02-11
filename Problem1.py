# Problem 1 : Validate Binary Search Tree 
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inOrderTraversal(node):
            # indicate that a preval refers to a preval in the nearest enclosing scope that is not the global scope.
            nonlocal preVal 

            # Base case - if current node is none then return true
            if node is None:
                return True
            
            # Traverse the left tree
            if not inOrderTraversal(node.left):
                return False
            # Check the previous value of the node in-order traversal. If the value of previous node is greater than the current node then it is breaching the BST value.
            if preVal >= node.val:
                return False
            # Assigning the node value to preVal for next loop
            preVal = node.val

            # Traverse the right tree
            if not inOrderTraversal(node.right):
                return False
            
            return True

        # Storing the value of previous node in preVal
        preVal = float('-inf')
        return inOrderTraversal(root)
        
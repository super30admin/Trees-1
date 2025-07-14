# Time Complexity: O(n)
# Space Complexity: O(h)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: Setting the prev variable as a class variable to maintain state across recursive calls.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        return self.dfs(root)
    
    def dfs(self, root: TreeNode) -> bool:

        # If we reach a None node, it is valid
        # This is the base case for the recursion and also returns if only one node is present
        # which is always valid as a BST
        if root is None:
            return True
        
        # Recursively check the left subtree
        # If the left subtree is not valid, return False
        if not self.dfs(root.left):
            return False
        # Check the current node's value against the previous node's value
        # If the previous node exists and its value is greater than or equal to the current node
        # then it is not a valid BST, return False
        if self.prev is not None and self.prev.val >= root.val:
            return False

        # Update the previous node to the current node
        self.prev=root 

        # Recursively check the right subtree
        # If the right subtree is not valid using the above check, return False
        return  self.dfs(root.right)

        

        

        
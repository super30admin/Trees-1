# https://leetcode.com/problems/validate-binary-search-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # prev = None
        # isValid = True
        # def helper(root):
        #     nonlocal prev, isValid
        #     if root == None:
        #         return
            
        #     helper(root.left)
        #     if prev and prev.val >= root.val:
        #         isValid = False
        #     prev = root
        #     helper(root.right)
        
        # helper(root)
        # return isValid



        """
        Time Complexity: O(N)
        - N is the total number of nodes in the binary tree.
        - We visit every single node exactly once to check its value against the boundaries.
        
        Space Complexity: O(N) in the worst case, O(log N) in the best/average case
        - The space is consumed by the recursion call stack.
        - Worst case: O(N) if the tree is completely unbalanced (like a linked list).
        - Best/Average case: O(log N) if the tree is balanced, where the height of 
          the tree dictates the maximum depth of the recursive stack.
        """
        
        # Helper function that passes the valid boundary limits down the tree
        def helper(node, minVal, maxVal):
            # Base Case: Reaching the end of a branch (an empty node) means 
            # this path is valid so far.
            if node == None:
                return True
            
            # Logic: The current node must be strictly greater than the minimum boundary.
            # (minVal is updated when we move to the right child of an ancestor).
            if minVal is not None and node.val <= minVal:
                return False
            
            # Logic: The current node must be strictly less than the maximum boundary.
            # (maxVal is updated when we move to the left child of an ancestor).
            if maxVal is not None and node.val >= maxVal:
                return False
            
            # Recursive Step:
            # 1. Check the left subtree: The current node's value becomes the new strict upper limit (maxVal).
            # 2. Check the right subtree: The current node's value becomes the new strict lower limit (minVal).
            # Both sides must return True for the entire tree to be valid.
            return helper(node.left, minVal, node.val) and helper(node.right, node.val, maxVal)
            
        # Start at the root. Initially, there are no upper or lower boundaries.
        return helper(root, None, None)
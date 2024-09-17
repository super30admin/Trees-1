"""
// Time Complexity :T = O(n) for traversing through entire BT.
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
Push nodes in stack
Compare previous > current, return False
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    previous = None

    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root)

    def helper(self,root:TreeNode )->bool:
        """
        Don't declare previous inside recursive function as it
        will be re-assigned =None in each recursive call"""
        # previous = None

        # base condition
        if root == None: return True

        # logic
        """
        if the left subtree is invalid,entire BT is invalid
        No need to check right subtree.
        """
        if self.helper(root.left) == False:
            return False

        if self.previous is not None and self.previous.val >= root.val:
            return False

        self.previous = root
        """
        if left subtree is valid,
        check right subtree is valid or not
        """
        return self.helper(root.right)




#iterative approach
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        previous = None
        stack = []

        while root is not None or len(stack) != 0:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop(-1)

            if previous is not None and previous.val >= root.val:
                return False
            previous = root
            root = root.right
        return True

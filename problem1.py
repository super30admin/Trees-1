#Time Complexity : O(n) - visit all the nodes
#Space Complexity : O(h) - O(n) for skewed and O(logn) for the best case scenario
#Any problem you faced while coding this : -

#The approach is to perform inorder traversal. We maintain a previous node and a flag. The previous node is to check the child is smaller than the root and if not set the flag as False.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True

    def inorder(self, root):
        # if not self.flag:
        #     return

        if root is None:
            return

        if self.flag:
            self.inorder(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        self.prev = root

        if self.flag:
            self.inorder(root.right)


    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag



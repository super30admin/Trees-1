# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)

# The code ran on LeetCode

# Perform an inorder trversal and return False if the elements are not in ascending order. Maintain a prev pointer to always point to the previous node in the graph

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = None
        def inorder(root):
            if root == None:
                return 

            inorder(root.left)
            if self.prev and root.val <= self.prev.val:
                self.flag = False

            self.prev = root
            inorder(root.right)
        inorder(root)
        return self.flag
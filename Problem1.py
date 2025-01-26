# Do the inorder traversal, keep a prev variable to store the parsed node, if the prev is ever grater or equal to current node then it's not valid return False
# TC: O(n)
# SC: O(h)
# Yes, this worked in leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Flag = None
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        # self.Flag = True
        # self.inorder(root)
        return self.inorder(root)

    def inorder(self, Node):
        if Node == None:
            return True
        if not self.inorder(Node.left):
            return False
        if self.prev != None and self.prev.val >= Node.val:
            # self.Flag = False
            return False
        self.prev = Node
        # self.inorder(Node.right)
        return self.inorder(Node.right)

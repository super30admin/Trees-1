'''
This is tricky, you have to make sure that how do you define a helper, and returning the right flag is the key.

Still need to figure out when you need a helper function to solve a problem vs without helper function.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev:Optional[TreeNode] = None
        self.flag = Truez
        def helper(root):

            if root is None:
                return
            helper(root.left)

            if(self.prev!=None and self.prev.val>=root.val):
                self.flag = False

            self.prev = root

            helper(root.right)


        helper(root)
        return self.flag





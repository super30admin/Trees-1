# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Our approach here is to use the recursion to validate the binary tree, here we are using the inorder traversal to achieve this. Inorder traversal is left - root - right. One rule: whenever you process the parent add it to the recurisve stack and then proceed to the childhren.
'''
'''
Time Complexity: O(n)
Space Complexity : O(n)
'''


class Solution:
    prev = None
    flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        # this is the code where we process the root first
        self.inorder(root)
        return self.flag

    def inorder(self, root):

        # base case
        if (root == None):
            return
        # going left
        self.inorder(root.left)
        if (self.prev != None and self.prev.val >= root.val):
            self.flag = False
        # stack.pop()

        self.prev = root
        # going over the right tree
        self.inorder(root.right)
        # stack.pop()
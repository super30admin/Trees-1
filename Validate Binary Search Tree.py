# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

"""
Approach1: Iterative Inorder Traversal
"""


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        prev = None
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            #print(root.val)
            #if prev root value is greater than current root
            #not BST
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True

"""
Approach2: Checking range of each node based on BST definition , recursive traversal
"""
# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         return self.helper(root,None,None)

#     def helper(self,root,minimum,maximum):
#         if root==None: #empty tree is valid BST
#             return True
#         if(maximum!=None and root.val>=maximum):
#             return False
#         if(minimum!=None and root.val<=minimum):
#             return False

#         #left and right subtree validation
#         return (self.helper(root.left,minimum,root.val) and self.helper(root.right,root.val,maximum))



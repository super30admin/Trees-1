'''
time complexity: O(n)
space complexity: O(n) or O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root==None: return True
        prev = None
        stack = []
        while(root!=None or len(stack)>0):
            while(root!=None):
                stack.append(root)
                root=root.left
            root = stack.pop()
            if(prev!=None and prev>=root.val):
                return False
            prev = root.val
            root = root.right
        return True
        
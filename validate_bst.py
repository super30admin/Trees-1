# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#time complexity: O(n)
#space complexity: O(h)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root==None: return root
        self.isValid=None
        self.prev=None
        def inorder(root):
            if root==None:
                return
            inorder(root.left)
            if self.prev!=None and self.prev.val>=root.val:
                self.isValid=False
            self.prev=root
            print(root.val)
            inorder(root.right)
            
#         s=[]

#         while(root!=None or len(s)!=0):
#             while(root!=None):
#                 s.append(root)
#            
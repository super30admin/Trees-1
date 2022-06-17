""""// Time Complexity : O(n)
// Space Complexity : O(h), h-height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Recursion Min and Max:
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)
        # return self.helper(root, float('-inf'), float('inf'))

    def helper(self, root, mini, maxi):
        # base
        if not root:
            return True
        if mini != None and root.val <= mini:
            return False
        if maxi != None and root.val >= maxi:
            return False
        x = self.helper(root.left, mini, root.val)
        if x:
            y = self.helper(root.right, root.val, maxi)
        return x and y

# Recursion Min and Max with Flag-
# class Solution:
#     def __init__(self):
#         self.flag= True
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.helper(root, None, None)
#         return self.flag
#     def helper(self, root, mini, maxi):
#         #base
#         if not root:
#             return
#         if mini!=None and root.val<=mini:
#             self.flag=False
#         if maxi!=None and root.val>=maxi:
#             self.flag=False
#         self.helper(root.left, mini, root.val)
#         self.helper(root.right, root.val, maxi)


# Iterative Min and Max-
# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         st=[]
#         mini=float('-inf')
#         maxi=float('inf')
#         while root!=None or st:
#             while root:
#                 st.append((root, mini,maxi))
#                 mini=mini
#                 maxi=root.val
#                 root=root.left
#             r=st.pop()
#             root=r[0]
#             mini=r[1]
#             maxi=r[2]
#             if not root:
#                 return True
#             if mini!=None and root.val<=mini:
#                 return False
#             if maxi!=None and root.val>=maxi:
#                 return False
#             root=root.right
#             mini=r[0].val
#             maxi=r[2]
#         return True


# Recursion Inorder-
# class Solution:
#     def __init__(self):
#         self.prev = None

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         return self.inorder(root)

#     def inorder(self, root):
#         if not root:
#             return True

#         x= self.inorder(root.left)
#         if self.prev!= None and self.prev.val>=root.val:
#             return False
#         else:
#             self.prev=root


#         if x:
#             y=self.inorder(root.right)
#         return x and y


# Recursion Inorder Flag-
# class Solution:
#     def __init__(self):
#         self.prev = None
#         self.flag= True

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.inorder(root)
#         return self.flag

#     def inorder(self, root):
#         if not root:
#             return

#         self.inorder(root.left)
#         if self.prev!= None and self.prev.val>=root.val:
#             self.flag=False
#         else:
#             self.prev=root
#         if self.flag==True:
#             self.inorder(root.right)

# Iterative Inorder-
# class Solution:
#     def __init__(self):
#         self.st = []
#         self.prev = None
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         while root!=None or self.st:
#             while root!=None:
#                 self.st.append(root)
#                 root=root.left
#             root=self.st.pop()
#             if self.prev!= None and self.prev.val>=root.val:
#                 return False
#             else:
#                 self.prev=root
#             root=root.right
#         return True

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.inorder(root)

#     def inorder(self, root):
#         #base
#         if not root:
#             return
#         #logic
#         self.inorder(root.left)
#         #stack.pop()
#         print("UP")
#         print(root.val)
#         self.inorder(root.right)
#         print("DOWN")
#         print(root.val)

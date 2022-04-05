# Time Complexity :- O(n)
# Space Complexity :- O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.stack = []
        self.result = []
        self.previous = float('-inf')

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        while (root != None):
            self.stack.append(root)
            root = root.left

        while (self.stack != []):
            node = self.stack.pop()
            if self.previous != None and self.previous >= node.val:
                return False
            self.previous = node.val
            node = node.right
            while (node != None):
                self.stack.append(node)
                node = node.left

        return True

#     def __init__(self):

#         #self.result = []
#         self.flag = True
#         self.previous = float('-inf')
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         inorder = self.inorder(root)

#         # i = 1
#         # while(i != len(self.result)):
#         #     if (self.result[i-1] >= self.result[i]):
#         #         return False
#         #     i+=1
#         return self.flag

#     def inorder(self,root):

#         ## Base case
#         if root == None:
#             return None


#         # Traverse Left node

#         leftroot = self.inorder(root.left)


#         # Traverse node

#         if root.val <= self.previous:
#             self.flag = False
#             return
#         self.previous = root.val

#         #self.result.append(root.val)

#         # Traverse right node

#         rightnode = self.inorder(root.right)


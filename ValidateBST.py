#Getting the in-order list and checking it is in ascending
#TC: O(n)
#SC: O(n) #We can optimise space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
global outputLis
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.outputLis=[]
        self.helperFunction(root)
        print(self.outputLis)
        for i in range(1, len(self.outputLis)):
            if self.outputLis[i]<=self.outputLis[i-1]:
                return False
        return True

    def helperFunction(self, node):
        if node is None:
            return
        self.helperFunction(node.left)
        self.outputLis.append(node.val)
        self.helperFunction(node.right)
        
#TC:O(n)
#SC:O(1) #Replicated the previous approach with just 2 pointers
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
global flag
global prev
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag=True
        self.prev=None
        self.helperFunction(root)
        return self.flag

    def helperFunction(self, node):
        if node is None:
            return
        self.helperFunction(node.left)
        if self.prev and self.prev.val>=node.val:
            self.flag=False
        self.prev=node
        self.helperFunction(node.right)


#TC:O(n)
#SC:O(1) # Replicated the previous approach with just 2 pointers
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
global prev
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev=None
        return self.helperFunction(root)
         
    def helperFunction(self, node):
        if node is None:
            return True
        left=self.helperFunction(node.left)
        if self.prev and self.prev.val>=node.val:
            return False
        self.prev=node
        right=self.helperFunction(node.right)
        return left and right
# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes



#Iterative approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if(root==None):
            return False
        prev=None
        stack=[]
        while(root!=None or stack!=[]):
            while(root!=None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            if(prev!=None and prev.val>=root.val):
                return False
            prev=root
            root=root.right
        return True
            
        
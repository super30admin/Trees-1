"""
//Time Complexity : O(n)
// Space Complexity :O(Height)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #Mathematical approach
        if root == None:
            return True
        return self.inorder(root,None,None)
    def inorder(self,root,min1,max1):
        if root==None:
            return True
        if(self.inorder(root.left,min1,root.val)==False):
            return False
        if((min1!=None and root.val<=min1) or (max1!=None and root.val>=max1)):
            return False
        return self.inorder(root.right,root.val,max1)
        
        #1st approach
#         prev = None
#         if root == None:
#             return True
        
#         isValid = True
#         s = []
#         while(root!=None or  len(s)!=0):
#             while(root!=None):
#                 s.append(root)
#                 root=root.left
#             root = s.pop()
#             if (prev!=None and prev.val>=root.val):
#                 isValid=False
#             prev = root
#             root = root.right
#         return isValid
    
    
    
    #second approach
    # def inorder(self,root):
    #     global prev
    #     prev=None
    #     if root == None:
    #         return
    #     self.inorder(root.left)
    #     if prev!=None and (prev.val >= root.val):
    #         isValid = False
    #     prev=root
    #     self.inorder(root.right)
    
          
        
        
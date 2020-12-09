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
        # self.prev=None
        # def inorder(root):
        #     if root==None:return True
        #     if inorder(root.left)==False:
        #         return False
        #     if self.prev!=None and self.prev.val>=root.val:
        #         return False
        #     self.prev=root
        #     return inorder(root.right)
        # return inorder(root)
        
        
#         stack, prev = [], None
        
#         while stack or root:
#             while root:
#                 stack.append(root)
#                 root = root.left
#             root = stack.pop()
#             if root.val <= prev:
#                 return False
#             prev = root.val
#             root = root.right

#         return True



        mini=float('-inf')
        maxi=float('inf')
  
        def helper(root,mini,maxi):
            if root==None:
                return True
            
            left=helper(root.left,mini,root.val)
            if mini>=root.val:
                return False
            if maxi<=root.val:
                return False
            right=helper(root.right,root.val,maxi)
            return left and right
        return helper(root,mini,maxi)

#O(N)
#O(ht of tree) for iterative stack/>>> O(1) for recursive
        


        
    
        
        
#TC-> O(N)
#SC-> O(N)
'''RECURSIVE SolutioN'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution(object):
#     def isValidBST(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """
#         self.__inorder(root)
#         return True

#     def __inorder(self, root):
#         if root == None:
#             return
#         self.__inorder(root.left)
#         self.__inorder(root.right)

#******************************************************

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#prev = None
class Solution(object):
    prev = None
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.__inorder(root)

    def __inorder(self,root):
        #global prev
        #base case 
        if root == None:
            return True 
        
        #Logic   
        left = self.__inorder(root.left)
        if self.prev!=None and self.prev.val >=root.val:
            return False
        #move prev to root
        self.prev = root
        #do the same on right
        right = self.__inorder(root.right)
        
        return left and right
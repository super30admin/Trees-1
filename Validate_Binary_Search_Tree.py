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
        https://www.youtube.com/watch?v=MILxfAbIhrE
        """
        self.check = True
        def Valid(left,right,root):
            if root is None:
                return
            else:
                if root.val > left and root.val < right:
                    if root.left is not None:
                        Valid(left,root.val,root.left)
                    if root.right is not None:
                        Valid(root.val,right,root.right)
                else:
                    print(left,right,root.val)
                    self.check = False
        Valid(-2147483649, 2147483648,root)
        return self.check
#         self.final = []
#         def inorder(root):
#             if root is None:
#                 return
            
#             inorder(root.left)
#             self.final.append(root.val)
#             inorder(root.right)
        
#         inorder(root)
#         print(self.final)
#         for i in range(1,len(self.final)):
#             if self.final[i] <= self.final[i-1]:
#                 print(self.final[i],self.final[i-1])
#                 return False
#         return True
            
            
                
# Time Complexity : O(number of nodes)
# space Complexity : O(n)
# Validating if a this is BST
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #global variables
    prev = None
    isValid = True
    def inOrder(self,root):
        if root==None:
            return
        self.inOrder(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            #using self to use and change them
            #returing to prevent the code from checking all the nodes
            self.isValid=False
            return
        self.prev = root
        self.inOrder(root.right)

    def isValidBST(self, root: TreeNode) -> bool:
        if root==None:
            return True    
        self.inOrder(root)
        return self.isValid
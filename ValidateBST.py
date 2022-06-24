# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

''' Time Complexity: O(n)
Space Complexity: O(h)'''
class Solution(object):
    
    def __init__(self):
        self.prev=TreeNode()
        self.prev=None
        self.flag=True
    
    def inorder(self,root):
        if not root:
            return 
        
        self.inorder(root.left)
        #print("prev", self.prev)
        #print(root.val)
        
        if self.prev is not None and self.prev.val >= root.val:
            self.flag=False
            
        if self.flag==False:
            return
        self.prev=root
        self.inorder(root.right)

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.inorder(root)
        return self.flag
        #We cannot just check for the left and right nodes because it will not work for all the inputs
        #Therefore we can use inorder traversal (LEFT-ROOT-RIGHT) and it should be in increasing order
        

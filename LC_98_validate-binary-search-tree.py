#TC-> O(N)
#SC-> O(N)
'''Using Iterative solution'''

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
    #initiating our own stack like recursive stack
        stack = []
        prev = None
        
        while root!=None or stack!=[]:
            while root!=None: #we are going untill end of the Node
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            if prev!=None and prev.val>=root.val:
                return False
            prev = root
            root = root.right
        
        return True
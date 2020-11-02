# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        globalanswer = [True]
        
        def dfs(node):
            amIBST = True
            smallest = largest = node.val
            
            if node.left:
                s, l, b = dfs(node.left)
                smallest = min(s, smallest)
                largest = max(l, largest)
                if not b or node.val <= l:
                    amIBST = False
                    
            if node.right:
                s,l,b = dfs(node.right)
                smallest = min(s, smallest)
                largest = max(l, largest)
                if not b or node.val >= s:
                    amIBST = False
                    
            if amIBST is False:
                globalanswer[0] = False
            return smallest, largest, amIBST
        
        dfs(root)
        return globalanswer[0]
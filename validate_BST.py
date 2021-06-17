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
        :space complexity:O(n)
        :time complexity: O(n)
        """
        m=float('-inf')
        M=float('inf')
        return self.validate(root, m, M)
    
    def validate(self, root, minn, maxx):
        # base case
        if root is None:
            return True
        
        # optimization
        if minn is not None and root.val <=minn: 
            return False
        
        if maxx is not None and root.val >=maxx: 
            return False
       
        # logic
        case1= self.validate(root.left, minn, root.val) 
        #stack.pop()
        case2 = self.validate(root.right, root.val, maxx)
        return case1 and case2

       
            
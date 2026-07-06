#Problem 98. VALIDATE BINARY SEARCH TREE
# TIME COMPELXITY: O (N) where N is the number of nodes
# SPACE COMPLEXITY: O(H) where H is the height of the tree


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        
        return self.helper(root,None,None)

    def helper(self,root,minValue,maxValue):
        if root is None:
            return True
            
        if minValue is not None and root.val<=minValue:
            return False
            
        if maxValue is not None and root.val>=maxValue:
            return False

        return self.helper(root.left,minValue,root.val) and self.helper(root.right,root.val,maxValue)
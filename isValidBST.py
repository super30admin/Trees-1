# Time Complexity: O(n)
# Space Complexity: O(h)

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
        if root == None: # If empty tree, it's a valid BST
            return True
        
        def helper(root):
            if root == None:
                return True
            case1 = helper(root.left)
            if self.prev != None  and self.prev.val >= root.val:
                return False
            self.prev = root
            case2 = helper(root.right)
            return case1 and case2

        
        self.prev = None
        return helper(root)
        
        
        

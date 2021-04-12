# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity is O(n), n being the Number of Nodes
# Space complexity is O(h), h being the height of the tree
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = []
        prev = -sys.maxint-1
        while(root is not None or len(stack) != 0):
            while(root):
                stack.append(root)
                root = root.left  
            root = stack.pop()
            if(root.val <= prev):
                return False
            prev = root.val
            root = root.right
        return True
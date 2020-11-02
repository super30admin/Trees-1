# Time Complexity: O(n) - number of tree nodes
# Space Complexity: O(h) - height of tree - recursive stack space
# Approach:
# Bottom up DFS - recursion
# Any arbitrary node in the tree can be viewed as a worker that delegates subproblems to subordinates
# What information do you need from every subordinate?
#   1. largest value in my left subtree, smallest value in my right subtree
#   2, is my left/right subtree a BST?
#   if largest val left < my value < smallest val right --> valid BST

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

        global_answer = [True]
        def dfs(node):
            amIBST = True
            smallest,largest = node.val, node.val
            
            # Base Case - Leaf - PASS
            
            # Recursive case
            if node.left is not None:
                (s, l, b) = dfs(node.left)
                smallest = min(s, smallest)
                largest = max(l, largest)
                if not b or l >= node.val:
                    amIBST = False
            if node.right is not None:
                (s, l, b) = dfs(node.right)
                smallest = min(s,smallest)
                largest = max(l, largest)
                if not b or node.val >= s:
                    amIBST = False
            if amIBST == False:
                global_answer[0] = False
            return (smallest, largest, amIBST)
        
        if root is None:
            return True
        dfs(root)
        return global_answer[0]
            
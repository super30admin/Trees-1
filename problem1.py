# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack =[]
        prev = None
        while root is not None or stack:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            print(root.val)
            if (prev is not None and prev >= root.val): return False
            prev = root.val
            root = root.right
        return True

#Time complexity is O(n) where n is the number of nodes in the tree
#Space complexity is O(h) where h is the height of the tree
#Iterative approach is used where each node value is compared with the previous value
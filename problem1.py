#validate binary search tree
#space complexity:O(n) 
#time complexity: O(n) where n is the size of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        #using inorder traversal L-Root-Right
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            if root.val<=self.prev:
                return False
            self.prev = root.val
            return inorder(root.right)
        self.prev = -math.inf
        return inorder(root)
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n) where n is the number of nodes in the tree
# Space Complexity --> O(log n) which is the height of the tree
# Approach --> Have a previous val that keeps updating as we make inorder recursive calls and compare it with current root val. 
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = None
        self.helper(root)
        return self.flag
    
    def helper(self, root):
        # base
        if root is None:
            return

        # logic
        self.helper(root.left)
        if self.prev is not None and self.prev.val>=root.val:
            self.flag = False

        self.prev = root
        if self.flag:
            self.helper(root.right)



'''
# Time Complexity --> O(n) where n is the number of nodes in the tree
# Space Complexity --> O(log n) which is the height of the tree
# Approach --> range-based recursion where we pass the min and max values as parameters for each function call and make boundary checks for the root value
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, min_val, max_val):
        # base
        if root is None:
            return True 

        # logic
        left = self.helper(root.left, min_val, root.val)

        if min_val is not None and root.val<=min_val:
            return False
        if max_val is not None and root.val>=max_val:
            return False

        if left:
            right = self.helper(root.right, root.val, max_val)

        return left and right
'''

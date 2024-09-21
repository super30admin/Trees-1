# Time and Space complexity - O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root, low, high):
            if not root:
                return True
        
            if root.val <= low or root.val >= high:
                return False

            return helper(root.left, low, root.val) and helper(root.right, root.val, high)
            
        return helper(root, float('-inf'), float('inf'))




        # self.prev = None
        # self.ans = True

        # def traverse(root):
        #     if not root:
        #         return

        #     traverse(root.left)
        #     if self.prev != None and self.ans:
        #         self.ans = self.prev < root.val

        #     self.prev = root.val
        #     traverse(root.right)
        
        # traverse(root)
        # return self.ans

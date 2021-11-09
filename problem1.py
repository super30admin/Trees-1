"""
Time complexity: O(n)
Space complexity: O(1)
"""

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = None
        stack = []
        while root!=None or len(stack) > 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev!= None and prev >= root.val:
                return False
            prev = root.val
            root = root.right
        return True
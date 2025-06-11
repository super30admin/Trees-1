"""
Time - O(n)
Space - O(1)
Runs on leetcode - YES
"""

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.prev = None

        def inorder(node):
            if not node or not self.flag:
                return

            inorder(node.left)

            if self.prev is not None and self.prev >= node.val:
                self.flag = False
                return

            self.prev = node.val
            inorder(node.right)

        inorder(root)
        return self.flag
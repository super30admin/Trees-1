class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inOrderTraversal(node):
            if not node:
                return True
            if not inOrderTraversal(node.left):
                return False
            if self.lastVal is not None and node.val <= self.lastVal:
                return False
            self.lastVal = node.val
            return inOrderTraversal(node.right)

        self.lastVal = None
        return inOrderTraversal(root)

#Time complexity : O(N)
#Space complexity : O(N)

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def valid(node, left, right):
            if node:
                if (node.val <= left) or (node.val >= right):
                    return False
                return valid(node.left, left, node.val) and valid(
                    node.right, node.val, right
                )
            return True

        return valid(root, -float("inf"), float("inf"))
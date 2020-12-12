# Time: O(N)
# Space: O(N)

class Solution:
    def isValidBST(self, root):
        if not root: return False
        stack = []
        node = root
        prev = TreeNode(float("-inf"))
        while node or stack:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            if node.val <= prev.val:
                return False
            prev = node
            node = node.right

        return True
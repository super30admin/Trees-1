#Time Complexity: O(n)
#Space Complexity: O(n)
#Successfully submitted to leetcode: yes

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None
        if not root:
            return True
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and prev.val>=root.val:
                return False
            prev = root
            root = root.right
        return True
        
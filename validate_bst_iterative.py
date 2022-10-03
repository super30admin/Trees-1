# TC: O(n)
# SC: O(h)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return False
        stack = []
        # prev = TreeNode(None)
        prev = None
        while root != None or len(stack)!= 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True

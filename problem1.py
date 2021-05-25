class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        prev = None
        while (root != None or len(stack) != 0 ):
            while(root!= None):
                stack.append(root)
                root = root.left
            root = stack.pop()

            if (prev!= None and prev.val>=root.val ):
                return False
            prev = root
            root = root.right

        return True

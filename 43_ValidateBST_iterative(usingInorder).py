# iterative solution using InorderTraversal and stack
# First moving towards root and then if we reach the leaf, go to right and repeat.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # base case
        if not root: return True
        stack = []
        prev = TreeNode(None)
        while (root or len(
                stack) != 0):  # do this multiple times until we have traversed all nodes or till the stack is empty
            while root:  # if root is not none, repeat until leaf and change the root at every step to it's left node.
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev.val != None and root.val <= prev.val:  # if prev is not none and value of root is less than prev return False
                print(prev.val, root.val)
                return False
            prev = root
            root = root.right

        return True
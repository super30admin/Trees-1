# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # iterative inorder traversal
    """
    TC: O(n)
    SC: O(max. depth of the tree)
    """

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        # 1. Base case
        if root == None:
            return True

        # 2. when root is not empty or null
        stack = []
        prev = None

        # check if there are elem in stack
        # when the right child of the root is empty
        while len(stack) != 0 or root != None:
            # push all the elements to the left of the root
            # into the stack
            while root != None:
                stack.append(root)
                root = root.left

            # pop the last root from stack
            curr = stack.pop()

            # check if prev is smaller than curr or not
            if prev != None and prev.val >= curr.val:
                return False
            prev = curr

            # move to the right child of the curr elem
            root = curr.right

        return True

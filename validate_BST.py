# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    prev = None

    # res = True
    #   Recursivly calling below fuction and on root of the tree and calling it on left and right child of the tree

    # Time Complexity: O(n2)
    # Space Complexity: O(H) - height of tree
    def checkBST(self, root):
        if not root:
            return True

        if not self.checkBST(root.left):
            return False

        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.checkBST(root.right)
        # return True

    # Validate the BST using the range algorithm
    def rangeBST(self, root, min_val, max_val):
        #         if root is null return true
        if not root:
            return True
        #         if root does not lie between the current min and max value then return false
        if not min_val < root.val <= max_val:
            return False
        #         And if not then based on current min and max value we will call recursively on left and right subtree of the tree
        return self.rangeBST(root.left, min_val, root.val - 1) and self.rangeBST(root.right, root.val, max_val)

    # Implementing the range algorithm using the iterative solution

    def rangeBSTIterative(self, root):
        #         Defining the min val and max val and stack to store current head
        #  we will be appending main root of the tree in the stack as we will be going root by root and checking the condition

        min_val = float("-inf")
        max_val = float("inf")
        stack = []
        stack.append((root, min_val, max_val))
        #         until stack is completely empty we wil go through the stack

        while stack:
            # we will get the current stack element with its min and max value at that instance
            curr_root, curr_min, curr_max = stack.pop()
            #
            #       if the root does not lie between range then we will return false
            if curr_min >= curr_root.val or curr_root.val > curr_max:
                return False
            # or els eif root has left child then we will append it in stack with its current min and max value and same for right child if prrsent
            if curr_root.left:
                stack.append((curr_root.left, curr_min, curr_root.val - 1))

            if curr_root.right:
                stack.append((curr_root.right, curr_root.val, curr_max))

        return True

    #     recursive BSt brute force
    def recursiveBST(self, root):
        res = True
        return self.checkBST(root)
        return self.res

    def isValidBST(self, root):

        return self.rangeBST(root, float("-inf"), float("inf"))
        return self.rangeBSTIterative(root)
        return self.recursiveBST(root)
        """
        :type root: TreeNode
        :rtype: bool
        """

#passed in leetcode
#space- constant
#Time - On(n)
#here if you are moving left then update the max and when you are moving right update min
#left part of bst should a bst and have all elements left to it less than it and all elements right to it shoulf be greater than it
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#leetcode 98 - 2nd sol did not pass leetcode, not able to find the error

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.helper_func(root, None, None)

    def helper_func(self, root, min_tree, max_tree):
        # base case --- In any recursive solution we deal with the base case in the end
        if (root == None):
            return True
        if (min_tree != None and root.val <= min_tree):
            return False
        if (root.val >= max_tree and max_tree != None):
            return False
        return (self.helper_func(root.left, min_tree, root.val) and self.helper_func(root.right, root.val, max_tree))


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# time - O(n)
# space - O(n) as we are usinf stack
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:  # base case
            return True
        stack = []
        prev = TreeNode(None)
        while (root != None and stack != 0):
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and root.val <= prev.val:
                return False
            prev = root
            root = root.right
        return True


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:  # base case
            return True
        stack = []
        prev = TreeNode(None)
        while (root != None and stack != 0):
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev.val != None and root.val <= prev.val:
                return False
            prev = root
            root = root.right
        return True






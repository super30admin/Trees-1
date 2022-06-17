# Time Complexity : O(n)
# Space Complexity : O(h); h -- height of the tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# iterative
# by checking min and max at each and every node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.stack = []

    def isValidBST(self, root):
        min = float('-inf')
        max = float('inf')
        while root or self.stack:
            while root:
                self.stack.append([root, min, max])
                max = root.val
                root = root.left
                min = min
            pop = self.stack.pop()
            root = pop[0]
            if pop[1] >= root.val or root.val >= pop[2]:
                return False
            root = root.right
            min = pop[0].val
            max = pop[2]
        return True


check = TreeNode(40)
check.left = TreeNode(30)
check.right = TreeNode(50)
check.left.left = TreeNode(20)
check.left.right = TreeNode(35)
check.left.left.left = TreeNode(10)
check.left.left.right = TreeNode(25)
check.left.right.left = TreeNode(32)
check.left.right.right = TreeNode(37)
check.right.left = TreeNode(45)
check.right.right = TreeNode(60)
check.right.left.left = TreeNode(42)
check.right.left.right = TreeNode(49)
check.right.right.left = TreeNode(55)
check.right.right.right = TreeNode(80)
check1 = Solution()
print(check1.isValidBST(check))


# iterative
# Using inoder traversal
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.stack = []
#         self.prev = None
#
#     def isValidBST(self, root):
#         while root or self.stack:
#             while root:
#                 self.stack.append(root)
#                 root = root.left
#             root = self.stack.pop()
#             if self.prev and self.prev.val >= root.val:
#                 return False
#             self.prev = root
#             root = root.right
#         return True
#
#
# check = TreeNode(40)
# check.left = TreeNode(30)
# check.right = TreeNode(50)
# check.left.left = TreeNode(20)
# check.left.right = TreeNode(35)
# check.left.left.left = TreeNode(10)
# check.left.left.right = TreeNode(25)
# check.left.right.left = TreeNode(32)
# check.left.right.right = TreeNode(37)
# check.right.left = TreeNode(45)
# check.right.right = TreeNode(60)
# check.right.left.left = TreeNode(42)
# check.right.left.right = TreeNode(49)
# check.right.right.left = TreeNode(55)
# check.right.right.right = TreeNode(80)
# check1 = Solution()
# print(check1.isValidBST(check))


# using Recursion
# by checking min and max at each and every node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def isValid(self, root, min, max):
#         if root is None:
#             return True
#         if root.val <= min or root.val >= max:
#             return False
#         x = self.isValid(root.left, min, root.val)
#         y = True
#         if x:
#             y = self.isValid(root.right, root.val, max)
#         return x and y
#
#     def isValidBST(self, root):
#         return self.isValid(root, -100000, 100000)
#
#
# check = TreeNode(40)
# check.left = TreeNode(30)
# check.right = TreeNode(50)
# check.left.left = TreeNode(20)
# check.left.right = TreeNode(35)
# check.left.left.left = TreeNode(10)
# check.left.left.right = TreeNode(25)
# check.left.right.left = TreeNode(32)
# check.left.right.right = TreeNode(37)
# check.right.left = TreeNode(45)
# check.right.right = TreeNode(60)
# check.right.left.left = TreeNode(42)
# check.right.left.right = TreeNode(49)
# check.right.right.left = TreeNode(55)
# check.right.right.right = TreeNode(80)
# check1 = Solution()
# print(check1.isValidBST(check))

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.prev = None
#
#     def inOrder(self, root):
#         if not root:
#             return True
#         if not self.inOrder(root.left):
#             return False
#         if self.prev and self.prev.val >= root.val:
#             return False
#         self.prev = root
#         return self.inOrder(root.right)
#
#     def isValidBST(self, root):
#         return self.inOrder(root)
#
#
# check = TreeNode(5)
# check.left = TreeNode(1)
# check.right = TreeNode(8)
# check.right.left = TreeNode(3)
# check.right.right = TreeNode(9)
# check1 = Solution()
# print(check1.isValidBST(check))


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.prev = None
#
#     def inOrder(self, root):
#         if not root:
#             return True
#         x = self.inOrder(root.left)
#         if self.prev and self.prev.val >= root.val:
#             return False
#         self.prev = root
#         if x:
#             y = self.inOrder(root.right)
#         return x and y
#
#     def isValidBST(self, root):
#         return self.inOrder(root)
#
#
# check = TreeNode(5)
# check.left = TreeNode(1)
# check.right = TreeNode(8)
# check.right.left = TreeNode(7)
# check.right.right = TreeNode(9)
# check1 = Solution()
# print(check1.isValidBST(check))


# Using flag.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.prev = None
#         self.flag = True
#
#     def inOrder(self, root):
#         if not root:
#             return True
#         self.inOrder(root.left)
#         if self.prev and self.prev.val >= root.val:
#             self.flag = False
#         self.prev = root
#         if self.flag:
#             self.inOrder(root.right)
#
#     def isValidBST(self, root):
#         self.inOrder(root)
#         return self.flag
#
#
# check = TreeNode(5)
# check.left = TreeNode(1)
# check.right = TreeNode(8)
# check.right.left = TreeNode(3)
# check.right.right = TreeNode(9)
# check1 = Solution()
# print(check1.isValidBST(check))

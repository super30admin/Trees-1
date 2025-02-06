"""
The inorder traversal of BST is sorted.
Approach1: The idea of comparing a node with its left and right child won't work because what if this node satisfies
the best property, but what if the right child is lesser than the root of a tree.
So at every node we need to compare the root with its right subtree and left subtree, not its immediate children.
TC: O(n^2)

Approach2: The in-order traversal of BST is sorted. The idea is to store the inorder traversal in the array and
then use 2 pointers the prev and curr pointer to check if it is sorted.
TC: O(n) that is number of nodes
SC: O(h) stack size + O(n) array size
Edge case: there are no duplicates in the array

Approach3: Can we do this check while traversing the tree? yes. In the in order traversal, update the previous to root
 when root is moved to the next node.
 TC: O(n) and SC: O(h)
"""
from typing import Optional


class TreeNode:
    def __init__(self, val, left, right):
        self.val = val
        self.right = None
        self.left = None


root = TreeNode(5, None, None)
Node1 = TreeNode(1, None, None)
Node2 = TreeNode(4, None, None)
root.left = Node1
root.right = Node2
Node3 = TreeNode(3, None, None)
Node4 = TreeNode(6, None, None)
Node2.left = Node3
Node2.right = Node4


class Solution:
    def helper_inorder(self, node, lst):
        if node is None:
            return
        # inorder traversal Left Root Right or Right Root Left
        self.helper_inorder(node.left, lst)
        lst.append(node.val)
        self.helper_inorder(node.right, lst)

    def helper_with_conditional_recursion(self, node, flag, prev):  # Flag and previous would be global variables. Flag
        # is the answer that needs to be returned, and since we are comparing the root with the whole subtree it should
        # be global.

        if not node:
            return

        self.helper_using_tree_validate_bst(node.left)

        if prev[0] and prev[0] <= node.val:  # since initially, prev would be None, need to check of prev exists.
            # Check if BST property is violated
            flag[0] = False

        prev[0] = node

        self.helper_using_tree_validate_bst(node.right)

    def helper_with_boolean_recursion(self, node, prev):
        if not node:
            return True

        left = self.helper_with_boolean_recursion(node.left, prev)

        if prev[0] and node.val <= prev[0].val:
            return False

        prev[0] = node

        rigth = self.helper_with_boolean_recursion(node.right, prev)

        return left and rigth

    def helper_with_recursion(self, node, prev, flag):
        if not node:
            return

        if flag[0]:
            self.helper_2(node.left, prev, flag)

        if prev[0] and node.val <= prev[0].val:
            flag[0] = False

        prev[0] = node

        if flag[0]:
            self.helper_2(node.right, prev, flag)

    def helper_with_conditional_and_boolean_recursion(self, node, prev):
        if not node:
            return True

        left = self.helper_with_conditional_and_boolean_recursion(node.left, prev)
        if not left:
            return

        if prev[0] and node.val <= prev[0].val:
            return False

        prev[0] = node

        rigth = self.helper_with_conditional_and_boolean_recursion(node.right, prev)
        if not left:
            return

        return left and rigth
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        flag = [True]
        prev = [None]
        self.helper_using_tree_validate_bst(root, prev, flag)
        return flag[0]

obj = Solution()

lst = []
# obj.helper_inorder(root, lst)
# prev = 0
# ans = True
# for curr in range(1, len(lst)):
#     if lst[curr] < lst[prev]:
#         ans = False
#         break
#     prev += 1
#
# if ans:
#     print("valid BST")
# else:
#     print("not valid BST")

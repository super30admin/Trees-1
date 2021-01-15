# Created by Aashish Adhikari at 10:19 AM 1/14/2021

'''
Time Complexity:
O(n) since in the worst case we are reaching at every node.

Space Complexity:
O(h) where h is the height of the tree.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        # Iteratively traverse a binary search tree in-order and store the values
        # After traversal, check if the values are in strictly-ascending order

        from collections import deque

        recursive_stack = deque()
        prev = None

        while root is not None or len(recursive_stack) != 0:


            # INORDER --> traverse the left side

            while root is not None:
                # store the current node
                recursive_stack.append(root)
                # now traverse to the left side of this node
                root = root.left


            # INORDER --> at root
            root = recursive_stack.pop()

            if prev is not None and prev.val >= root.val:
                return False


            prev = root

            # INORDER --> traverse the right side
            root = root.right




        return True

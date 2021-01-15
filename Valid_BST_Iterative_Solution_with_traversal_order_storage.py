# Created by Aashish Adhikari at 8:25 PM 1/13/2021

'''
Time Complexity:
O(n) + O(n) ~ O(n) since we are traversing all the nodes.

Space Complexity:
In the worst case, the number of elements in the recursive stack is the height of the tree.
But we are also creating a new list of length equal to the no of nodes in the tree.
O(h) + O(n)


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

        inorder_traversal = []
        # Iteratively traverse a binary search tree in-order and store the values
        # After traversal, check if the values are in strictly-ascending order

        from collections import deque

        recursive_stack = deque()

        while root is not None or len(recursive_stack) != 0:


            # INORDER --> traverse the left side

            while root is not None:
                # store the current node
                recursive_stack.append(root)
                # now traverse to the left side of this node
                root = root.left


            # INORDER --> at root
            root = recursive_stack.pop()
            inorder_traversal.append(root.val)

            # INORDER --> traverse the right side
            root = root.right


        for idx in range(1, len(inorder_traversal)):
            if inorder_traversal[idx] > inorder_traversal[idx-1]:
                pass
            else:
                return False

        return True

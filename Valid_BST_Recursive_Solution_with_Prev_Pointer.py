# Created by Aashish Adhikari at 2:39 PM 1/14/2021

'''
Time Complexity:
O(n) as we visit each node once.

Space Complexity:
O(h) where h is the height of the recursive stack.
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def inorder(self, node):

        if node is None:
            return True



        case1 = True
        case2 = True

        # to the left
        if node.left is not None:
            case1 = self.inorder(node.left)

        # use the global prev element to check the ascending order
        if self.prev_val is not None and self.prev_val >= node.val:
            return False

        # update the prev for the right child
        self.prev_val = node.val




        # to the right
        if node.right is not None:
            case2 = self.inorder(node.right)

        if case1 and case2:
            return True
        else:
            return False



    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """


        self.prev_val = None

        # traverse and store inorder
        return self.inorder(root)


















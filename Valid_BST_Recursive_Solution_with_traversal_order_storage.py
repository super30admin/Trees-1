# Created by Aashish Adhikari at 10:21 AM 1/14/2021

'''
Time Complexity:
O(n) as we reach all the nodes once

Space Complexity:
O(n) since we are storing all the elements in the ascending order
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def inorder(self, node):


        # to the left
        if node.left is not None:
            self.inorder(node.left)

        # mid node
        self.asc_order.append(node.val)

        # to the right
        if node.right is not None:
            self.inorder(node.right)







    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        self.asc_order = []


        # traverse and store inorder
        self.inorder(root)

        for idx in range(1,len(self.asc_order)):
            if self.asc_order[idx] <= self.asc_order[idx-1]:
                return False

        return True


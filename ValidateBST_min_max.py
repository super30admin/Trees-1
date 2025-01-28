# Time Complexity : O(n), n is no of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using two variables - min and max to keep track of the values recursively
# this solution is independent of any type of traversal
# at any time, the value of a node should lie between the range of min and max, if not, the tree is not BST
# the values of min and max are set as follows:
# left subtree -> min value is the left most child, but since t is yet to be found, we start with None/null
# left subtree -> max value is the value of the root node, because every node should be smaller than the parent node in left subtree
# right subtree -> min value is same as the parent's min
# right subtree -> max value is right most child, which is yet to be found, so we set it to None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # global variables are necessary, will not work with local variables
        self.prev = None
        self.isvalid = True

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # self.inorder(root)
        # return self.isvalid
        self.checkValidity(root, None, None)
        return self.isvalid
        

    def checkValidity(self, root, min, max):
        # base case
        if root is None:
            return

        # left traversal, min remains same and the max is the value of the parent
        # because if we are moving left, the values should be smaller than the parent
        self.checkValidity(root.left, min, root.val)

        # logic - if the current node's value is less than min and greater than max, then it means the tree is not BST
        if (min is not None and root.val <= min) or (max is not None and root.val >= max):
            self.isvalid = False
        
        # right traversal, min is the root, because on moving right, the values should be more than the parent node
        # and the max remains same
        self.checkValidity(root.right, root.val, max)
    
    # def inorder(self, root):
    #     # base case
    #     if root is None:
    #         return
    #     # left traversal
    #     self.inorder(root.left)

    #     # logic
    #     if self.prev is not None and self.prev.val >= root.val:
    #         self.isvalid = False
    #         return

    #     self.prev = root

    #     # right traversal
    #     self.inorder(root.right)

        
        
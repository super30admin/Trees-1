# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if not root:
            return True
        """
        self.breachFound=True
        self.prev = None
        def helper(root):
            if not root:
                return

            helper(root.left) 
            #Check with the previous value. Why previous?
            # Inorder traversal of a BST will always give us
            # the sorted value.
            if (self.prev != None and self.prev.val >= root.val):
                #breach
                self.breachFound = False
                return
            
            #This node looks good. Update prev and explore right subtree.
            self.prev = root
            helper(root.right)

            return
        helper(root)
        return self.breachFound
        """

        """
        TC : O(n) <--- all the nodes are visited once at max.
        SC : O(h) <--- height of the tree. Worst case, it will be O(n)
                       in case of a skewed tree.
        """
        def helper(root, minVal, maxVal):
            if not root:
                return True

            if (root.val <= minVal or root.val >= maxVal):
                return False
            # If we are going left in a BST, all the numbers on the left subtree
            # should be lesser that the currentValue. There is no bound of minimum
            # as we don;t care about it.
            left = helper(root.left, minVal, root.val)
            # If we are going right in a BST, all the numbers on the right subtree
            # should be greater that the currentValue. There is no bound of maximum
            # as we don;t care about it.
            right = helper(root.right, root.val, maxVal)

            #Return True if no breaches found.
            return left and right

        return helper(root, float('-inf'), float('inf'))
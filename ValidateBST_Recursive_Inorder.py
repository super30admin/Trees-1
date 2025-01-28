# Time Complexity : O(n), n is no of elements in the array
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# recursive apporoach
# this approach is dependent on the inorder traversal, if sorted then BST validated
# we use a prev node to keep track of the previous node
# recursively, we check if the value of the next node is greater than the current node
# it means that the traversal is not in sorted order
# the property for inorder traversal of BST is breached and we make isvalid false



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.prev = None
        self.isvalid = True

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.inorder(root)
        return self.isvalid

    
    def inorder(self, root):
        # base case, for leaf nodes, once reached, it means left of the parent root is completed
        if root is None:
            return
        
        # left traversal, moving to the left of the node
        self.inorder(root.left)

        # logic - if prev is > than current root, we return false
        if self.prev is not None and self.prev.val >= root.val:
            self.isvalid = False
            return

        # prev gets root's value (current node)
        self.prev = root

        # right traversal, and we move root to the right
        self.inorder(root.right)

        
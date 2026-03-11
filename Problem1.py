# https://leetcode.com/problems/validate-binary-search-tree/

# Validate BST

# Time Complexity : O(n) => As we are traversing through the entire tree, n being the total number of tree nodes
# Space Complexity : O(h) => Where h is the height of the tree, if it's a balanced tree then O(log n)

# This solution implements recursion. We are comparing the root node with a prev node. The prev node is initialized to None. 
# The idea is to keep moving the prev pointer in such a way that we will assign the root to the prev after we have checked if
# the condition if prev is not null and if prev value is more than or equal to root and return a flag as false. 
# We detect a breach if prev is more than the curr root. In a BST, every value on the left is less than the curr node and the right
# node is more than the curr. 

class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

    def helper(self, root):
        if root is None:
            return 

        self.helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        self.prev = root
        self.helper(root.right)
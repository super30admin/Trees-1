'''

Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
For recursive: Check if the node value inside the tree is between high and low, if it is then True else False

For Inorder Solution: We need to check the previous value is less than the current value as long as this is true
return true else false

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def __init__(self):
        self.prev = None

    def inorder(self, root, prev):
        if root == None:
            return True

        # if left subtree returns false
        if not self.inorder(root.left, self.prev):
            return False

        # Check if value less than prev
        if self.prev != None and root.val <= self.prev:
            return False

        self.prev = root.val

        return self.inorder(root.right, self.prev)

    def helper(self, root: TreeNode, upper, lower) -> bool:
        if root == None:
            return True

        val = root.val
        if (lower != None and val <= lower) or (upper != None and val >= upper):
            return False

        return self.helper(root.left, val, lower) and self.helper(root.right, upper, val)

    def isValidBST(self, root: TreeNode) -> bool:
        return self.inorder(root, None)



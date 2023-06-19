# Time Complexity : O(n)
# Space Complexity : O(h) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  We ensure that the property of the BST is held at all nodes as we go down.
# We need to ensure that entire left/right subtree of a node, is less/greater than the node itself.
# So we pass the left and right limits along the recursion to perform the check.
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def helper(root, lLimit, rLimit):
            if not root:
                return True
            if lLimit < root.val < rLimit:
                return helper(root.left, lLimit, root.val) and helper(root.right, root.val, rLimit)
            return False
        
        return helper(root, -float('inf'), float('inf'))
"""
Time Complexity : O(n)
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
"""
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        # Passing the min and max val in the recursive calls
        return self.inorder(root, None, None)
    def inorder(self, root: Optional[TreeNode], minVal: int, maxVal: int) -> bool:
        if root == None:
            return True
        # If my min is not less than current root return false
        if self.inorder(root.left, minVal, root.val) == False:
            return False
        # If minVal not less than root and maxVal not greater than root
        # we return False
        if (minVal != None and minVal >= root.val) or (maxVal != None and maxVal <=             root.val):
            return False
        return self.inorder(root.right, root.val, maxVal)
# Time Complexity : O(n)

# space complexity : O(h)

# Approach :

# use dfs
# for left subtree the max value will always be the the parent node, and min value will be the min node
# for right subtree the max value will be the maximum value and minimum will be the parent node

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        maxVal = None
        minVal = None
        result = self.checkValidity(root, maxVal, minVal)
        return result

    def checkValidity(self, root, maxVal, minVal):

        if root is None:
            return True

        isValidLeft = self.checkValidity(root.left, root.val, minVal)

        if (minVal is not None and minVal >= root.val) or (maxVal is not None and maxVal <= root.val):
            return False

        isValidRight = self.checkValidity(root.right, maxVal, root.val)
        return isValidLeft and isValidRight

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.isValid = True
        self.helper(root, None, None)
        return self.isValid

    def helper(self, root: Optional[TreeNode], Min : int, Max: int) -> None:
        if root == None:
            return

        self.helper(root.left, Min, root.val)
        if (Min != None and root.val <= Min) or (Max != None and root.val >= Max):
            self.isValid = False
            return
        self.helper(root.right, root.val, Max)

# Time complexity - O(n)
# Space complexity - O(h) 
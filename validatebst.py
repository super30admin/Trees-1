class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, float('-inf'), float('inf'))
    
    def helper(self, root: Optional[TreeNode], low: float, high: float) -> bool:
        if root is None:
            return True
        
        if not (low < root.val < high):
            return False

        left=self.helper(root.left, low, root.val)
        #st.pop
        right=self.helper(root.right, root.val, high)
        #st.pop

        return left and right
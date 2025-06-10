# TC: O(n)
# SC: O(h)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        flag=True
        def helper(root, low, high):
            nonlocal flag
            if not flag or root == None:
                return
            
            helper(root.left, low, root.val)
            helper(root.right, root.val, high)

            if root.val <= low or root.val >= high:
                flag=False
                return
        
        helper(root, float('-inf'), float('inf'))
        return flag
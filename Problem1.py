# Time Complexity: O(N)
# Space Complexity: O(N) - recursion stack depth
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
      def helper(node, lower, upper):
        if not node:
          return True 
        
        return lower < node.val < upper and \
          helper(node.left, lower, node.val) and \
          helper(node.right, node.val, upper)

      return helper(root, -float("inf"), float("inf"))

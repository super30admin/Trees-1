# Time Complexity : O(n) [n = number of elements in preorder list]
# Space Complexity : O(log n) [n = number of elements in preorder list, in other words height of tree]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Problem approach
# 1. For any node all the nodes on its left have lesser value than node and all the nodes on the right have greater value
# 2. Using this property we can start from root and pass along the min_value and max_value for each left child and right child recursive call
# 3. The node value and must be greater than min_val and lesser than max_val
# 	3.1 For left child recirsive call, the max_val is updated to node.val
# 	3.2 For right child recirsive call, the min_val is updated to node.val
class Solution:
    def isValidBSTUtil(self, root, min_val, max_val):
    	# Base case
        if not root:
            return True
        if root.val > min_val and root.val < max_val and self.isValidBSTUtil(root.left, min_val, root.val) and self.isValidBSTUtil(root.right, root.val, max_val):
            return True
        
        return False
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:return True
        min_val = float(-inf)
        max_val = float(inf)
        return self.isValidBSTUtil(root, min_val, max_val)
# Time complexity: O(n)
# Space complexity: O(logn)
# Works on leetcode: yes
# Approach: The approach here is to recursively traverse the BST and check if any root/parent is less than it's left node
# or greater than it's right node. 
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, -float("inf"), float('inf'))
    
    def helper(self, root, left, right):
        if not root:
            return True
        if root.val <= left or root.val>=right:
            return False
        return self.helper(root.left,left,root.val) and self.helper(root.right,root.val,right)
        
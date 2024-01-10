#Time Complexity: O(n)
#Space Complexity: O(n)
#Submit on Leetcode: yes 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isValidBST(self, root:TreeNode) -> bool:

        def helper(node, left, right):
            if not node:
                return True
            
            if not (node.val > left and node.val < right):
                return False
            
            return helper(node.left, left, node.val) and helper(node.right, node.val, right)
        return helper(root, float('-inf'), float('inf'))


sol = Solution()

tree_root = TreeNode(2)
tree_root.left = TreeNode(1)
tree_root.right = TreeNode(3)

# Check if the constructed tree is a valid BST
result = sol.isValidBST(tree_root)

# Print the result
if result:
    print("The tree is a valid BST.")
else:
    print("The tree is not a valid BST.")
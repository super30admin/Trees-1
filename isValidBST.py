#space = O(h)
#time = O(n)
class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def validate(node, lower=float('-inf'), upper=float('inf')):
            if not node:
                return True
            if node.value <= lower or node.value >= upper:
                return False
            return (validate(node.left, lower, node.value) and
                    validate(node.right, node.value, upper))
        
        return validate(root)

# Example usage:
# Constructing a valid BST:
#     2
#    / \
#   1   3

tree = TreeNode(2)
tree.left = TreeNode(1)
tree.right = TreeNode(3)

sol = Solution()
print(sol.isValidBST(tree))  # Output: True

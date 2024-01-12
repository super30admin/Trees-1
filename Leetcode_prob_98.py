# problem name: Validate Binary Search Tree
# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: Inorder traversal of BST is always sorted. So, we can do inorder traversal and check if the previous value is less than the current value or not. If not, then it is not a valid BST.
# Edge cases:
# 1. Empty tree
# 2. Tree with single node
# 3. Tree with all the nodes on the left side
# 4. Tree with all the nodes on the right side
# 5. Tree with nodes on both the sides

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def in_order_traversal(node):
            nonlocal prev_val

            if not node:
                return True
            if not in_order_traversal(node.left):
                return False
            if prev_val is not None and node.val <= prev_val:
                return False
            
            prev_val = node.val 
            return in_order_traversal(node.right)
        
        prev_val = None
        return in_order_traversal(root)

# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def isValidBST(self, root):
        def validate(node, min_val=float('-inf'), max_val=float('inf')):
            if not node:
                return True
            if not min_val < node.val < max_val:
                return False
            return (validate(node.left, min_val, node.val) and
                    validate(node.right, node.val, max_val))
        
        return validate(root)


# Time complexity - O(n) 
# Space complexity - O(h)

class Solution:
    def isValidBST(self, root):
        stack = []
        prev_val = float('-inf')
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= prev_val:
                return False
            prev_val = root.val
            root = root.right
        return True

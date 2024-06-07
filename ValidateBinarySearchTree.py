# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
class Solution:
    def __init__(self):
        self.prev = None
        self.isValid = True
    # In-Order Iterative solution for BST Validity Check
    def iterativeSolution(self, root):
        if root is None:
            return True
        stack = []
        prev = None
        while root is not None or stack:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev is not None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
    # In-Order Recursive Function
    def inOrder(self, root):
        if root is None or self.isValid is False:
            return
        self.inOrder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.isValid = False
            return
        self.prev = root
        self.inOrder(root.right)
    # In-Order Recursive solution for BST Validity Check
    def recursiveSolution(self, root):
        if root is None:
            return self.isValid
        self.inOrder(root)
        return self.isValid
    # Post-Order Min-Max Function
    def validity(self, root, min_val, max_val):
        if root is None:
            return True
        case1 = self.validity(root.left, min_val, root.val)
        case2 = self.validity(root.right, root.val, max_val)
        if ((min_val is not None and root.val <= min_val) or (max_val is not None and root.val >= max_val)):
            return False
        return case1 and case2
    # Post-Order Min-Max solution for BST Validity Check
    def isValidBST(self, root):
        if root is None:
            return True
        return self.validity(root, None, None)


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

solution = Solution()

# Example 1:
root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)
print(solution.iterativeSolution(root))  # Expected output: True
print(solution.recursiveSolution(root))  # Expected output: True
print(solution.isValidBST(root))  # Expected output: True

# Example 2:
root = TreeNode(5)
root.left = TreeNode(1)
root.right = TreeNode(4)
root.right.left = TreeNode(3)
root.right.right = TreeNode(6)
print(solution.iterativeSolution(root))  # Expected output: False
print(solution.recursiveSolution(root))  # Expected output: False
print(solution.isValidBST(root))  # Expected output: False

# Example 3:
root = TreeNode(10)
root.left = TreeNode(5)
root.right = TreeNode(15)
root.right.left = TreeNode(6)
root.right.right = TreeNode(20)
print(solution.iterativeSolution(root))  # Expected output: False
print(solution.recursiveSolution(root))  # Expected output: False
print(solution.isValidBST(root))  # Expected output: False
# Time Complexity : O(n)
# Space Complexity : O(n)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.map = {}
        self.index = 0

    def treeBuilder(self, preorder, start, end):
        if start > end:
            return None
        rootval = preorder[self.index]
        self.index += 1
        root = TreeNode(rootval)
        rootIndex = self.map[rootval]
        root.left = self.treeBuilder(preorder, start, rootIndex - 1)
        root.right = self.treeBuilder(preorder, rootIndex + 1, end)
        return root

    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        self.index = 0
        self.map = {val: idx for idx, val in enumerate(inorder)}
        return self.treeBuilder(preorder, 0, len(inorder) - 1)

# Helper function to print the tree in a readable form
def print_tree(node, level=0, label="."):
    indent = " " * (4 * level)
    if node is None:
        print("{}{}: None".format(indent, label))
        return
    print("{}{}: {}".format(indent, label, node.val))
    print_tree(node.left, level + 1, "L")
    print_tree(node.right, level + 1, "R")

# Examples
solution = Solution()

# Example 1
preorder1 = [3, 9, 20, 15, 7]
inorder1 = [9, 3, 15, 20, 7]
tree1 = solution.buildTree(preorder1, inorder1)
print("Example 1:")
print_tree(tree1)

# Example 2
preorder2 = [1, 2, 3]
inorder2 = [2, 1, 3]
tree2 = solution.buildTree(preorder2, inorder2)
print("\nExample 2:")
print_tree(tree2)

# Example 3
preorder3 = [1, 2, 4, 5, 3, 6]
inorder3 = [4, 2, 5, 1, 6, 3]
tree3 = solution.buildTree(preorder3, inorder3)
print("\nExample 3:")
print_tree(tree3)

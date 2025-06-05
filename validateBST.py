"""
Do an inorder traversal of the tree, which gives a sorted list.
Keep check of previous node value during traversal.
If the current node’s value is not greater than the previous, it's not a valid BST.
"""
"""
Time Complexity: O(n) Each node is visited once.
Space Complexity: O(h) Where h is the height of the tree
"""


from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class validateBST:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = None

        def helper(node):
            nonlocal prev
            if node is None:
                return True
            if not helper(node.left):
                return False
            if prev is not None and node.val <= prev.val:
                return False
            prev = node
            return helper(node.right)

        return helper(root)


if __name__ == "__main__":
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    obj = validateBST()
    print(obj.isValidBST(root)) 


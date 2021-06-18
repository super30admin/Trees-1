# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Iterative Solution using stack
    # def isValidBST(self, root: TreeNode) -> bool:
    #     stack = []
    #     prev = None
    #     while len(stack) != 0 or root != None:
    #         while root != None:
    #             stack.append(root)
    #             root = root.left
    #         root = stack.pop()
    #         if prev != None and prev.val >= root.val:
    #             return False
    #         prev = root
    #         root = root.right
    #     return True

    # Recursive Solution using Inorder Traversal
    # prev = None
    # def isValidBST(self, root: TreeNode) -> bool:
    #     if root == None:
    #         return True
    #     if self.isValidBST(root.left) == False:
    #         return False
    #     if self.prev != None and self.prev.val >= root.val:
    #         return False
    #     self.prev = root
    #     return self.isValidBST(root.right)


    # Recursive solution to check whether left and right sub trees are valid BST using ranges on each node.
    # Left node -> Rannge  = min :Same as parent, maximum changes to that of parent val
    # Right node -> Range =  max :Same as parent, minmum changes to that of parent val
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, None, None)
    
    def helper(self, root: TreeNode, minimum: int, maximum: int) -> bool:
        if root == None:
            return True
        if minimum != None and root.val <= minimum:
            return False
        if maximum != None and root.val >= maximum:
            return False
        return self.helper(root.left, minimum, root.val) and self.helper(root.right, root.val, maximum)

    # Time Complexity: O(n) where n is number of nodes of tree
    # Space Complexity: O(h) where h is height of tree
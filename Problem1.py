#I used the property that an inorder traversal of a valid Binary Search Tree (BST) produces a sorted list of unique values. First, I implemented an inorder traversal method that collects all the values of the tree in a list. Then, in the main isValidBST method, I call this inorder traversal on the given tree. To check if the tree is a valid BST, I compare the inorder traversal result with a sorted version of the same list after removing duplicates. If these are equal, it means the original tree's values were in ascending order and unique, which is a property of a valid BST.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorder(self, root: Optional[TreeNode], val_BST: List[int])-> List[int]:
        if root:
            self.inorder(root.left, val_BST)
            val_BST.append(root.val)
            self.inorder(root.right, val_BST) 
        return val_BST

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        inorder_val = self.inorder(root, [])
        return inorder_val == sorted(list(set(inorder_val)))
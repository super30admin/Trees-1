# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Time Complexicity: O(n), where n are number of items in given tree
    Space Complexicity: O(h), where h is height of the tree
    
    Problem: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    
    Approach:
    1. Using while loop with a stack data structure to know previous node and compare the value with current node
    2. Using a recursive solution where the stack operations are under the hood
    
    """
    """ Iterative Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root == None: return True
        stack = []; prev = TreeNode(-float('inf'))
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev.val != None and root.val != None:
                if prev.val >= root.val:
                    return False
            prev = root
            root = root.right
            
        return True
    """
    
    def __init__(self):
        self.prev = TreeNode(-float('inf'))
    
    def isValidBST(self, root: TreeNode) -> bool:
        return self.inOrder(root)
    
    def inOrder(self, root):
        
        if root == None: return True
        if not self.inOrder(root.left): return False
        if self.prev.val != None and root.val != None:
            if self.prev.val >= root.val: return False
        self.prev = root
        return self.inOrder(root.right)
            
            

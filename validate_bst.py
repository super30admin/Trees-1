""" 
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Time Complexity: O(n)
Space Complexity: O(h) = O(n) in worst case
"""

#recursive using void function.
def isValidBST(root):
    
    prev, flag = None, True
    
    def helper(root):
        nonlocal prev, flag
        
        if not root:
            return
        
        if root.left:
            helper(root.left)
            
        if prev and prev.val >= root.val:
            flag = False
            return
        
        prev = root

        if root.right:
            helper(root.right)
            
    helper(root)
    
    return flag

#recursive without using void function.
def isValidBST(root):
    
    prev = None
    
    def helper(root):
        nonlocal prev
        if not root:
            return True
        
        if not helper(root.left):
            return False
        
        if prev and prev.val >= root.val:
            return False
        
        prev = root
        if not helper(root.right):
            return False
        
        return True
    
    return helper(root)

#recursive using min and max.

def isValidBST(root):
    
    def helper(root, min, max):
        if not root:
            return True
        
        if root.val <= min or root.val >= max:
            return False
        
        return helper(root.left, min, root.val) and helper(root.right, root.val, max)
    
    return helper(root, float('-inf'), float('inf'))

#iterative inorder traversal.

def isValidBST(root):
    
    if not root:
            return []
        
    stack = []
    prev = None
    
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        
        root = stack.pop()
        if prev and prev.val >= root.val:
            return False
        
        prev = root
        root = root.right
        
    return True

#iterative inorder traversal using min and max.

def isValidBST(root):
    
    if not root:
        return True
    
    stack = []
    min, max = float('-inf'), float('inf')
    
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        
        root = stack.pop()
        
        if root.val <= min or root.val >= max:
            return False
        
        min = root.val
        root = root.right
        
    return True
    
    
    
    
    
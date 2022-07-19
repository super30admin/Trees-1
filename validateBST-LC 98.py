# Time Complexity = O(n)
# Space Complexity = O(h), where h is the height of the tree, because at one go, h elements are being pushed in the stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    # Recursive Code to Check if it is a Valid BST
    # Logic - Check if the in order traversal is in ascending order. Only the previous and current node is required to compare
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.prev = None            # Initialising the previous node
        self.isValid = True
        
        if root is None:
            return True
        
        self.inorder(root, self.prev)    
    
        return self.isValid
    

    
    def inorder(self, root, prev):
       
        if root == None:
            return
        self.inorder(root.left, self.prev)      # Left Subtree Traversal
        # print("left", root.val)
        
        # Boundary condition to avoid errors in a single node BST (self.prev != None)
        if self.prev != None and self.prev.val >= root.val:
            self.isValid = False
            return
        
        self.prev = root                        # Moving the pointer ahead
        self.inorder(root.right, self.prev)     # Right Subtree Traversal
        # print("right", root.val)
        


# Iterative Code to print inorder traversal
'''
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
    
        stack = []
        
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            print(root.val)
            root = root.right
            
'''        
        
    
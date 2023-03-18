# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Method 1 using recursion
class Solution:
    preOrderMin = - (2 ** 32)
    
    def recursiveBST(self, node):
        if node == None:
            return True
        
        #left
        if not (self.recursiveBST(node.left)):
            return False
        
        #node
        if (node.val <= self.preOrderMin):
            return False
        self.preOrderMin = node.val
        
        
        #right
        return self.recursiveBST(node.right)
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.recursiveBST(root)
       
# Method 2: Using Stack
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        inOrderPrev = -(2 ** 32)
        stack = TreeNode()
        stack = []
        
        while root != None:
            stack.append(root)
            root = root.left
        
        while len(stack) != 0:
            node = TreeNode()
            node = stack.pop()
            
            #current
            if(node.val <= inOrderPrev):
                return False
            inOrderPrev = node.val
            
            #right
            node = node.right
            
            #left
            while (node != None):
                stack.append(node)
                node = node.left
        return True
        
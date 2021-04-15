# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Doing an inorder traversal on a BST would give a sorted result.
""" Doing an inorder traversal on a BST would give a sorted result.
    Approach 1 - Recursion
    TC - O(n)
    SC - O(n) for recursive stack else O(1)
"""
class Solution:
    #count = 0
    def __inorder_traversal(self, root: TreeNode):
        # global previous\
        #print("Call number ------ [",self.count,"]")
        if not root:
            return
        #print("Got root as:" , root.val)
        
        #self.count += 1
        self.__inorder_traversal(root.left)
        
#         print("root :",root.val)
#         print("prev :", self.previous)
        
        if(self.previous is not None and self.previous.val >= root.val):
            
            #print("yes ", self.previous, "root val: ", root.val)
            self.isBST = False
        
        self.previous = root
        #self.count += 1
        self.__inorder_traversal(root.right)
            
    def isValidBST(self, root: TreeNode) -> bool:
        
        
        # A tree with no nodes is BST 
        if not root:
            return True
        
        self.isBST = True
        self.previous = None
        # previous of root is nothing
        #print("Initially value of previous:    ",self.previous) 
        #print("Starting with root at:   ", root)
        
        #self.count += 1 
        self.__inorder_traversal(root)
        
        return self.isBST
 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Approach 2 - Iterative implementation using Stack
TC - O(n)
SC - O(1)
"""
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        previous = None
        if not root:
            return True
        
        stack = []
        
        while(root is not None or stack):
            while(root is not None):
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            
            if (previous is not None and previous.val >= root.val):
                return False
            
            previous = root
            root = root.right
        
        return True
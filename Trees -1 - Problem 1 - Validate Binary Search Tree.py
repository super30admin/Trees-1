"""
S30 FAANMG Problem #41 {Medium}

98. Validate Binary Search Tree

Time Complexity : O(N)

Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  
We are using recursion, to traverse the Binary tree
Here we are perfoming inorder traversal

First Keep on moning to the rrot.left till it reached end of leaf noide

then the base condition pops the leaf
we check if the poped is less than the previous popped

if not then return False which is not a valid BST



@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.prev = None
        self.flag = False
        
     
    def inOrder(self, root):
        
        #base
        if(root == None):
            return
        
        
        if(self.flag):
            self.inOrder(root.left)
        
      
        #check with the previous node to check validity
        if(self.prev != None and self.prev.val >= root.val):
            self.flag = False
        
        self.prev = root
        
        if(self.flag):
            self.inOrder(root.right)
        
        
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.flag = True
        
        self.inOrder(root)
        
        return self.flag
        
"""
S30 FAANMG Problem #41 {Medium}

98. Validate Binary Search Tree

Time Complexity : O(N)

Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  
We are using stack , to traverse the Binary tree
Here we are perfoming inorder traversal

First Keep on moning to the root.left till it reached end of leaf noide

then the base condition pops the leaf
we check if the poped is less than the previous popped

if not then return False which is not a valid BST



@name: Rahul Govindkumar_RN27JUL2022
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
      
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        prev = None
                
        stack = deque()
        
        while(stack or root !=None):
            
        #Append the node and moving root.left till it reached the end
            while(root):
                stack.append(root)
                root = root.left
             
            #pop the last node
            root = stack.pop()
            
            #check with the previous node to check validity
            if(prev != None and prev.val >= root.val):
                return False
            
            prev = root
            
            #move to right node
            root = root.right
            
        return True
        
        
        
        
        
        
        
        

        
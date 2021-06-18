# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self): 
        self.result=True
        
    def isValidBST(self, root: TreeNode) -> bool:
        min, max=-98999999999,999999999999
        self.helper(root, min, max)
        return self.result
    
    def helper(self, root, min, max):
        if not root:
            return
        if root!=None and (root.val>=max or root.val<=min):
            self.result=False
            return
        case1=self.helper(root.left, min, root.val)
        case2=self.helper(root.right, root.val,max)

"""The above one is an implementation using helper with void return type and check min and max for each node"""
         
        
        
"""Implementation using helper with boolean return type and check min and max for each node"""      
#         min, max=-98999999999,999999999999
#         return self.helper(root,min, max)
    
#     def helper(self, root, min, max):
#         if not root:
#             return True
#         if root!=None and (root.val>=max or root.val<=min):
#             return False
#         return self.helper(root.left, min, root.val) and self.helper(root.right, root.val,max)
    
    
        
"""Implementation using helper with iterative approach using stack and check min and max for each node"""     
#         return self.helper(root)
    
#     def helper(self, root):
#         stack=[]
#         arr=[]
#         min, max=-98999999999,999999999999
#         if not root:
#             return
#         while root!=None or len(stack)!=0:
#             while root!=None:
#                 arr=[root,min, max]
#                 stack.append(arr)
#                 max=root.val
#                 root=root.left 
#             li=stack.pop()
#             root=li[0]
#             min=li[1]
#             max=li[2]
#             if root!=None and (root.val>=max or root.val<=min):
#                 return False
#             min=root.val
#             root=root.right  
#         return True
                
        
        
"""Implementation using recursive approach having prev value with Inorder function having  boolean return type """
#     def __init__(self):
#         self.prev=None
           
#     def isValidBST(self, root: TreeNode) -> bool:
#         return self.inOrder(root)

#     def inOrder(self, root)->bool:
#         if root==None:
#             return True
#         if self.inOrder(root.left)==False:
#             return False
#         if self.prev!=None and self.prev.val>=root.val:
#             return False
#         self.prev=root
#         return self.inOrder(root.right)


"""Implementation using recurssive approach having prev value with Inorder function having  void return type """
#         self.prev=None
#         self.result=True
        
#     def isValidBST(self, root: TreeNode) -> bool:
#         self.inOrder(root)
#         return self.result

#     def inOrder(self, root):
#         if root==None:
#             return
#         self.inOrder(root.left)
#         if self.prev!=None and self.prev.val>=root.val:
#             self.result=False
#             return
#         self.prev=root
#         self.inOrder(root.right)
        
    
"""Implementation using iterative approach having prev value with stack implementation"""
    
#         stack=[]
#         prev=None
#         if root is None:
#             return True
#         while root is not None or len(stack)!=0:
#             while root is not None:
#                 stack.append(root)
#                 root=root.left
#             root=stack.pop()
#             if prev!=None and prev.val>=root.val:
#                 return False
#             prev=root
#             root=root.right
#         return True
    
    
"""Time complexity-O(n) as we are traversing all elements in the BST
    Space Complexity-O(h) where h is the height of the tree and we use h amount of space while pushing elements into stack"""
        
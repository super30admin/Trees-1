
// Time Complexity : O(n+ n) 
//                   recursing and sorting, sort can be binary search
// Space Complexity : O(n+h) list + recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

'''
1. Perform inorder traversal
2. BST should be sorted when we look result of inordered lst

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.L=[]
        self.inorder(root)
        
        prev =self.L[0]
        
        for curr in self.L[1:]:
            if curr<=prev:
                return False
            else:
                prev=curr
            
    
        return True
        
        
    def inorder(self,node):
        
        if node ==None:
            return
        self.inorder(node.left)
        self.L.append(node.val)
        self.inorder(node.right)
        


// Time Complexity : O(n) 
//                   recursing through nodes
// Space Complexity : O(h) height of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

'''
1. Perform inorder traversal
3. Keep track of previous value. when prev and curr values are
 compared prev should always be low.
2. BST should be sorted when we look result of inordered lst

'''           


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.prev=float(-inf)
        self.flag=True
        self.inorder(root)    
    
        return self.flag
        
        
    def inorder(self,node):
        
        if node ==None:
            return
        self.inorder(node.left)
        
        if self.prev>= node.val:
                self.flag=False
        
        self.prev=node.val
            
        self.inorder(node.right)
        
            
            
                   
     
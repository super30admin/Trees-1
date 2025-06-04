# // Time Complexity :O(N)
# // Space Complexity :O(h) height of tree
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no
# https://leetcode.com/problems/validate-binary-search-tree/

# // Your code here along with comments explaining your approach
# I started of doing in order and adding elements to a list then comparing in list , but other optimal way would be just compare it with prev value

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root):
        self.prev = float('-inf')
        
        def inorder(node):
            if not node: return True
            
            if not inorder(node.left): return False
            
            if node.val <= self.prev: return False
            self.prev = node.val
            
            if not inorder(node.right):
                return False
            return True
        
        return inorder(root)



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inOrder(root,l):

            if root==None:return 
            

            inOrder(root.left,l)
            l.append(root.val)
            inOrder(root.right,l)
        
        p=[]
        inOrder(root,p)
        prev,curr=0,1
        if len(p)==1:return True
        n=len(p)
        while(curr<n):
            if p[prev]>=p[curr]:return False
            prev+=1
            curr+=1
        return True
        
        

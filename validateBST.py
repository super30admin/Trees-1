# Time Complexity : O(N) 
# Space Complexity :    O(H) ->H -max depth of the tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

#Approach
'''
If inorder traversal of a binary tree is sorted then its a valid BST
Maintain prev pointer to validate BST condition
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        '''
        if root==None:
            return False
        
        stack = []
        prev = None
        
        while(root!=None or len(stack)!=0):
            while(root!=None):
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev!=None and prev.val>=root.val:
                return False
            prev = root
            root = root.right
        return True
        '''
        
        return self.helper(root,None,None,None)
    
    def helper(self,root,prev,min,max):
        if root==None:
            return True
        if min!=None and min>=root.val:
            return False
        if max!=None and max<=root.val:
            return False
        
        #left recursive call - comparison range min remains same, max changes
        case1 = self.helper(root.left,root,min,root.val)
        
        #right recursive call - comparison range max is same, min changes
        case2 = self.helper(root.right,root,root.val,max)
        
        return case1 and case2
        
        
        
        
        
        

#TEST CASE
#[5,1,4,null,null,3,6]
#[2,1,3]
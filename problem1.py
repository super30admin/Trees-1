// Time Complexity : O(m)   //m=number of nodes
// Space Complexity : O(n)  //n=depth of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root==None:      //check if root is null
            return True
        
        #Inorder traversal
        pre=None
        stack=deque()
        
        while len(stack)!=0 or root!=None:    
            while root!=None:               //push all the left nodes of root to the stack
                stack.append(root)
                root=root.left
                
            #print(stack) 
            curr=stack.pop()      //pop the last left leaf node 
            #print(curr.val)
            
            #process curr (root)
            
            if pre!=None and pre.val >=curr.val:    //check if current val is than > pre or not
                return False
            
            pre=curr
            root=curr.right
        return True
        

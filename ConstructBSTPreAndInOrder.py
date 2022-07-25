# Time Complexity : O(N) //We are recursively traversing the tree till N nodes in trees
#  Space Complexity : O(H) //The recursive stack  used
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        #Base case
        if not preorder:
            return None
        
        #Using preorder[0] as root to determine root's left and right subtrees
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        #Determine the index with help of inorder
        rootIndex  = inorder.index(root.val)
        
        #Declare the inorder and preorder subtress
        inorderLeft = inorder[:rootIndex]
        inorderRight = inorder[rootIndex+1:]
        preorderLeft = preorder[1:rootIndex+1]
        preorderRight = preorder[rootIndex+1:]
        
        #Recursively call on the left and right subtrees
        root.left  = self.buildTree(preorderLeft,  inorderLeft )
        root.right = self.buildTree(preorderRight, inorderRight)
        
        return root
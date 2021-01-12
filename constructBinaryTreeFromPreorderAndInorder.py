# Time Complexity : O(N) #number of nodes
# Space Complexity : O(H) where H is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had trouble figuring out the right side


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        """
        Go through preorder array and find the node in the inorder array. 
            - Root.left should be on the side up to the element in the inorder array and the other side
            should be up to the element and after inside the inOrder array
        """
        if not preorder or not inorder or len(preorder) == 0 or len(inorder)!=len(preorder):
            return None
        
        return self.helper(preorder, inorder, 0,0, len(inorder)-1)
    
    def helper(self, preorder, inorder, preSt, inSt, inEnd):
        if preSt > len(preorder)-1 or inSt > inEnd:
            return None
        
        curr = TreeNode(preorder[preSt])
        
        i = inSt
        while i <= inEnd:
            if inorder[i] == preorder[preSt]:
                break
            i += 1
        
        curr.left = self.helper(preorder,inorder, preSt+1, inSt, i - 1)
        curr.right = self.helper(preorder,inorder, preSt+ (i- inSt + 1), i+1, inEnd)

        return curr
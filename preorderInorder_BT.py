# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if len(preorder)==0:
            return None
        
        root = TreeNode(preorder[0])
        
        #figure out position of root value in the inorder list
        index = -1
        for x in range(0, len(inorder)):
            if inorder[x] == root.val:
                index = x

        #create left and right arrays based on index value  
        preLeft = preorder[1:index+1]
        inLeft = inorder[0:index]
        preRight = preorder[index+1:len(preorder)]
        inRight = inorder[index+1:len(inorder)]
        
        #recurr at left and right
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root
        
"""
Time Complexity : buildTree - O(n^2)
Space Complexity : buildTree - O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    
    def buildTree(self, preorder, inorder) -> TreeNode:
        len_inOrder = len(inorder)
        len_preOrder = len(preorder)
        if inorder == None or len_inOrder == 0 or preorder == None or len_preOrder == 0:
            return None
        root = TreeNode(preorder[0])
        idx = -1
        for i in range(len_inOrder):
            if inorder[i] == root.val:
                idx = i
                break
                
        inLeft = inorder[0:idx]
        inRight = inorder[idx+1:len_inOrder]
        preLeft = preorder[1:idx+1]
        preRight = preorder[idx+1:len_preOrder]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root
    
inOrder = [3,9,20,15,7]
preOrder = [9,3,15,20,7]

s = Solution()
print(s.buildTree(preOrder, inOrder))
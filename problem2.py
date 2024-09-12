# Time Complexity : O(N^2) not sure
# Space Complexity : O(N^2) not sure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if len(preorder) == 0:
            return None
        
        rootElement = preorder[0]
        root = TreeNode(rootElement)
        rootIndex = 0
        for i in range(len(inorder)):
            if inorder[i] == rootElement:
                rootIndex += i
                
        leftInorder = inorder[0:rootIndex]
        leftPreorder = preorder[1:rootIndex+1]
        root.left = self.buildTree(leftPreorder,leftInorder)
        rightInorder = inorder[rootIndex+1:len(inorder)]
        rightPreorder = preorder[rootIndex+1:len(preorder)]
        root.right = self.buildTree(rightPreorder,rightInorder)
        
        return root
        
# Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal
# Time - O(n)
# Space - O(n2)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        
        if (len(preorder) == 0 or len(inorder) == 0):
            
            return
        
        root = TreeNode(preorder[0])
        
        inorderIndex = 0
        
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                inorderIndex = i
                break
                
        
        leftTreePreorder = preorder[1: inorderIndex + 1]
        leftTreeInorder = inorder[0: inorderIndex]
        
        rightTreePreorder = preorder[inorderIndex+1 : ]
        rigthTreeInorder = inorder[inorderIndex+1:]
        
        root.left = self.buildTree(leftTreePreorder, leftTreeInorder)
        root.right = self.buildTree(rightTreePreorder, rigthTreeInorder)
        
        
        return root
# Runs on Leetcode
# Runtime complexity - O(n^2)
# Memory complexity - O(n)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        
        left_inorder = inorder[:index]
        right_inorder = inorder[index+1:]
        
        left_preorder = preorder[1:1+index]
        right_preorder = preorder[1+index:]
        
        root.left = self.buildTree(left_preorder,left_inorder)
        root.right = self.buildTree(right_preorder,right_inorder)
        
        return root

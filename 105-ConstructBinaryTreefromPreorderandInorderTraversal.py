#Time Complexity : O(n2) 
# Space Complexity : O(n2) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if preorder is None or inorder is None or len(preorder) == 0:
            return None
        
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1
        
        for i in range(0,len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
        
        inorderLeft = inorder[0:rootIdx]
        inorderRight = inorder[rootIdx+1:len(inorder)]
        preorderLeft = preorder[1:rootIdx+1]
        preorderRight = preorder[rootIdx+1:len(preorder)]
        
        root.left = Solution.buildTree(self,preorderLeft,inorderLeft)
        root.right = Solution.buildTree(self,preorderRight,inorderRight)
        
        return root
        
        
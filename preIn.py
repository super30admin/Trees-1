#Time Complexity: O(n^2)
#Space Complexity: O(n^2)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if len(preorder) == 0:
            return None
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1
        
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
        
        inLeft = inorder[:rootIdx]
        inRight = inorder[rootIdx+1:]
        preLeft = preorder[1:len(inLeft)+1]
        preRight = preorder[len(inLeft)+1:]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        return root
        
        
        
        
        

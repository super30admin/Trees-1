#Time Complexity: O(n**2)
#Space Complexity:O(n**2)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0 or len(inorder)==0:
            return None
        root=TreeNode(preorder[0])
        rootIdx=0
        for i in range(len(inorder)):
            if inorder[i]==preorder[0]:
                rootIdx=i
            
        preleft=preorder[1 : rootIdx+1]
        preright=preorder[rootIdx+1 : len(preorder)]
        inleft=inorder[0 : rootIdx]
        inright=inorder[rootIdx+1 : len(inorder)]
        root.left=self.buildTree(preleft,inleft)
        root.right=self.buildTree(preright,inright)
        return root
        
        
       
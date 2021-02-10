# O(N) TIME AND O(N) SPACE WHERE N IS NO.OF NODES
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        indices = {inorder[i]:i for i in range(len(inorder))}
        return self.buildTreeHelper(preorder,inorder,indices,0,0,len(inorder)-1)
    
    def buildTreeHelper(self,preorder,inorder,indices,prestart,instart,inend):
        if prestart > len(preorder) - 1 or instart > inend:
            return None
        
        root = TreeNode(preorder[prestart])
        idx = indices[preorder[prestart]]
        
        root.left = self.buildTreeHelper(preorder,inorder,indices,prestart + 1,instart,idx - 1)
        root.right = self.buildTreeHelper(preorder,inorder,indices,prestart + idx - instart + 1 ,idx + 1,inend)
        return root
        
        
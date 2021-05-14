#Time complexity : 0(N)
# sapce complexity : 0(1)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def find_idx(self,key,st,se,inorder):
        for i in range(st,se+1):
            if inorder[i] == key:
                return i
        return -1
    def build(self,preorder,ps,inorder,ist,ie):
        
        if ps <0 or ist > ie:
            return None
        
        root = TreeNode(preorder[ps])
        
        idx = self.find_idx(preorder[ps], ist,ie,inorder)
        
        root.left = self.build(preorder,ps+1,inorder,ist,idx-1)
        root.right = self.build(preorder,ps+(idx-ist +1),inorder,idx+1,ie)
        
        return root
    
    def buildTree(self, preorder, inorder):
        
        if len(preorder) == 0:
            return None
        
        return self.build(preorder,0,inorder,0,len(inorder) - 1)
        
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
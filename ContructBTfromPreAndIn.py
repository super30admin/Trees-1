# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        '''Time Complexity: O(n^2) ---- Because of the list slicing
        Space Complexity: O(n) Stack space'''
        #Null case
        if len(preorder)==0:
            return None
    
        #First element of the preorder will be the root
        rootVal=preorder[0]
        root=TreeNode(rootVal)
        rootIdx=-1
        
        #Find the root index in inorder
        for i in range(len(inorder)):
            if inorder[i]==rootVal:
                rootIdx=i
        
        inorderLeft=inorder[:rootIdx]
        inorderRight=inorder[rootIdx+1:]
        
        preorderLeft=preorder[1:len(inorderLeft)+1]
        preorderRight=preorder[len(inorderLeft)+1:len(preorder)]
        
        root.left=self.buildTree(preorderLeft, inorderLeft)
        root.right=self.buildTree(preorderRight, inorderRight)
        
        return root
        

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    idx = 0
    h_map={}
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        for i in range(len(inorder)):
            self.h_map[inorder[i]] = i 
        
        
        def helper(left,right):
            if left>right:
                return None
            value = preorder[self.idx]
            root = TreeNode(value)
            self.idx+=1
            index = self.h_map[value]
            root.left = helper(left,index-1)
            root.right = helper(index+1,right)
            return root
                
        return helper(0,len(inorder)-1)
        
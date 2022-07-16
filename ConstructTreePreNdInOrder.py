# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity -> O(N)
#Space Complexity -> O(N)
class Solution:
    tab = dict()
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        root_index = -1
        self.index = 0
        for i in range(len(inorder)):
            self.tab[inorder[i]] = i
        
        def helper(preorder, inorder, start, end):
            if(start>end):
                return None
            rootval = preorder[self.index]
            self.index+=1
            root = TreeNode(rootval)
            root_index = self.tab.get(rootval)
            root.left = helper(preorder, inorder, start, root_index-1)
            root.right = helper(preorder, inorder, root_index+1, end)
            return root
        
        return helper(preorder, inorder, 0, len(preorder)-1)
        
    
            
        
        
                
        
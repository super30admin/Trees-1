# Time complexity: O(n) or O(n^2) if we dont use hashmap
# Space Complexity: O(n) for the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    ####### O(n^2) Time complexity ############
    # def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
#         if not preorder or not inorder:
#             return None
#         root = TreeNode()
#         root.val = preorder[0]
        
#         root_idx = -1
        
#         for i in range(len(inorder)): #Takes O(n) time
#             if inorder[i] == root.val:
#                 root_idx = i
        
#         pre_left = preorder[1:root_idx+1]
#         in_left = inorder[:root_idx]
#         in_right = inorder[root_idx+1:]
#         pre_right = preorder[root_idx+1:]
        
#         root.left = self.buildTree(pre_left,in_left)
#         root.right = self.buildTree(pre_right,in_right)
        
#         return root
    
    ####### O(n) Time complexity ############
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        hmap = {}
        
        for i in range(len(inorder)): #Takes O(n) time
            hmap[inorder[i]] = i
        
        return self.helper(preorder,0,len(preorder)-1,inorder,0,len(inorder)-1, hmap)
        
    def helper(self,preorder,prestart,preend,inorder,instart,inend,hmap):
        
        if prestart > preend or instart > inend:
            return None
        root = TreeNode(preorder[prestart])
        
        root_idx = hmap[root.val]
        
        num_left = root_idx - instart
        
        root.left = self.helper(preorder, prestart + 1, preend + num_left, inorder, instart, root_idx -1 , hmap)
        root.right = self.helper(preorder, prestart+num_left+1, preend, inorder, root_idx + 1, inend , hmap)
        
        return root
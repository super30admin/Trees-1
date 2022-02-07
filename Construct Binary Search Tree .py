# Time Complexity : O(N)
 # Space Complexity : O(H)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if(preorder == None or len(preorder) == 0) : return None
        # root = TreeNode[prenode[0]]            
        def helper(preorder: List[int], start:int, end:int):
            # base 
            
            nonlocal Idx 
            if start > end : return None
            # logic
            rootVal=preorder[Idx]
            Idx+=1
            root = TreeNode(rootVal)
            rootIdx = map[rootVal]
            root.left = helper(preorder, start,rootIdx -1)
            root.right = helper(preorder,rootIdx+1, end)
            return root
        Idx =0
        map ={}
        for i in range(len(preorder)):
            map[inorder[i]]=i
            
        return helper(preorder, 0, len(preorder)-1)
            
        
        
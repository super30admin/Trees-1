# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # Preorder = Root Left Right
        # Inorder = Left Root Right
        # Time Complexity - O(N)
        # Space Complexity - O(N)
        self.pre_idx=0  
        self.preorder=preorder
        self.inorder=inorder
        
        self.index_map={}
        # Creating map with key as inorder values and value to its index in inorder
        for idx in range(len(inorder)):
            self.index_map[inorder[idx]]=idx
            
        return self.helper(0,len(inorder)-1)
    
    def helper(self,left,right):
        if left>right:
            return None
        
        value=self.preorder[self.pre_idx]
        
        root=TreeNode(value)
        self.pre_idx+=1 # Incrementing pre_idx by 1
        
        index=self.index_map[value] # Getting the index of the current root using the index_map
        root.left = self.helper(left,index-1) # From left till index-1 will be to the left of the root
        root.right = self.helper(index+1,right) # From index+1 to the right will be to the right of the root
        
        return root
        
        
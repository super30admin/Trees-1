# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I have used a hashmap to store indices of value:indeices of inorder list
2. Then took the root from preorder to calculate the left subtree and right subtree fro inorder list
'''

class Solution:
    hash_dict = {}
    index = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
            
        for i in range(len(inorder)):
            self.hash_dict[inorder[i]] = i
        
        return self._helper(preorder, inorder, 0, len(inorder)-1)
      
        
    def _helper(self, preorder, inorder, start, end):
        
        
        if start > end or self.index > len(preorder):
            
            return None
            
        root = TreeNode(preorder[self.index]) 
        inorder_ind = self.hash_dict[root.val]

        self.index += 1
        root.left = self._helper(preorder, inorder, start, inorder_ind-1)
        root.right = self._helper(preorder, inorder, inorder_ind+1, end)
        
        return root
            
# Time Complexity :O(n) for all operations
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         TC-->O(n)
# SC--->O(1)
         
        if len(inorder) == 0:
            return None
        
        if len(preorder) == 1:
            return TreeNode(preorder[0])
        
        index = inorder.index(preorder.pop(0)) 
        root = TreeNode(inorder[index])
        root.left = self.buildTree(preorder, inorder[:index]) 
        root.right = self.buildTree(preorder, inorder[index+1:]) 
     
        return root
# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        midIdx = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:midIdx+1], inorder[:midIdx])
        root.right = self.buildTree(preorder[midIdx+1:], inorder[midIdx+1:])

        return root
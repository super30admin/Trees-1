#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None

        if len(preorder) == 1:
            return TreeNode(preorder[0])
        
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
       
        root.left = self.buildTree(preorder[1:mid + 1],inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:],inorder[mid + 1:])
        
        return root
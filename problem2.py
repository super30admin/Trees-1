"""
Time complexity: O(n)
Space complexity: O(n)
"""

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        root = TreeNode(preorder[0])
        inOrderIndex = 0
        for i in range(0, len(inorder)):
            if inorder[i] == root.val:
                inOrderIndex = i
                break
        
        leftSubtreePreorder = preorder[1: inOrderIndex+1]
        leftSubtreeInorder = inorder[0: inOrderIndex]

        rightSubtreePreorder = preorder[inOrderIndex+1: len(preorder)]
        rightSubtreeInorder = inorder[inOrderIndex+1: len(inorder)]

        root.left = self.buildTree(leftSubtreePreorder, leftSubtreeInorder)
        root.right = self.buildTree(rightSubtreePreorder, rightSubtreeInorder)
        
        return root
# Time Complexity :O(n**2)
# Space Complexity :O(n**2)
# Leet Code: Yes

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None

        root = TreeNode(preorder[0])
        idx = inorder.index(preorder[0])
        inorderleft = inorder[:idx]
        inorderright = inorder[idx+1:]
        preorderleft = preorder[1:len(inorderleft)+1]
        preorderright = preorder[len(inorderleft)+1:]

        root.left = self.buildTree(preorderleft, inorderleft)
        root.right = self.buildTree(preorderright, inorderright)

        return root
#construct binary tree for preorder and inorder traversal
#space compleixty: O(n)
#timecomplexity : O(n) where n is the size of the tree

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])#setting root at preorder 0 because Root-Left-right
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1],inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:],inorder[mid+1:])
        return root
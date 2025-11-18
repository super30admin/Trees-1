class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        Time complexity: O(n^2) if tree is skewed
        Space : O(h) where h is height of tree
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not inorder or not preorder:
            return None

        root_val = preorder[0]
        root = TreeNode(preorder[0])
        mid = inorder.index(root_val)
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        return root
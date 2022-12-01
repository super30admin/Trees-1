# ## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Given preorder and inorder traversal of a tree, construct the binary tree.
# TC : O(n)
# SC : O(1)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if inorder:
            root_index = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[root_index])
            # print(root.val, root_index)
            # print("calling left root")
            root.left = self.buildTree(preorder, inorder[:root_index])
            # print("root.left::", root.left)
            # print("calling right root")
            root.right = self.buildTree(preorder, inorder[root_index + 1:])
            # print("root.right::",root.right)
            return root
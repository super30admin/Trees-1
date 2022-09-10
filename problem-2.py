#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder and not inorder: return None
        index = inorder.index(preorder[0]) # Find index of root element from preorder root
        res = TreeNode(preorder[0]) #create root node of the tree
        res.left = self.buildTree(preorder[1:index+1], inorder[:index]) #recursive call for the left sub-tree
        res.right = self.buildTree(preorder[index+1:], inorder[index+1:]) #recursive call for right subtree
        return res
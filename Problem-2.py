#  105. Construct Binary Tree from Preorder and Inorder Traversal
'''
Leetcode all test cases passed: Yes
class Solution:
    def buildTree(self, preorder, inorder):
        n is the length of preorder
        h is the height of tree 
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return root

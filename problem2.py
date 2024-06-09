'''
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Time Complexity: O(n)
Space Complexity: O(n)
where n is the number of nodes
'''

# Definition for a binary tree node.
class TreeNode:
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

class Solution:
  def buildTree(self, preorder, inorder):
    self.preorder = preorder
    self.inorder = inorder
    self.inorderIndices = { value: index for index, value in enumerate(inorder) }
    self.preorderIdx = 0
    return self.buildTreeRecursive(0, len(inorder) - 1)

  def buildTreeRecursive(self, inorderLeft, inorderRight):
    #base case
    if inorderLeft > inorderRight:
      return None

    #logic
    rootValue = self.preorder[self.preorderIdx]
    self.preorderIdx += 1
    root = TreeNode(rootValue)
    inorderRootIdx = self.inorderIndices[rootValue]
    root.left = self.buildTreeRecursive(inorderLeft, inorderRootIdx - 1)
    root.right = self.buildTreeRecursive(inorderRootIdx + 1, inorderRight)
    return root

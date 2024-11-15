# TC: O(n) 
# SC: O(1)

from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def buildTree(preorder, inorder):
        preorder = deque(preorder)
        def helper(preorder, inorder):
            if inorder:
                root = preorder.popleft()
                root_idx = inorder.index(root)

                rootNode = TreeNode(root)

                rootNode.left = helper(preorder, inorder[:root_idx]) 
                rootNode.right = helper(preorder, inorder[root_idx + 1:])
                return rootNode
            else:
                return

        return helper(preorder, inorder)
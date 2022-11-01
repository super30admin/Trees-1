from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder, inorder):
        preorder = deque(preorder)
        return self.getTree(preorder,inorder)
    
    def getTree(self,preorder,inorder):
        if inorder:
            idx = inorder.index(preorder.popleft())
            root = TreeNode(inorder[idx])
            root.left = self.getTree(preorder,inorder[:idx])
            root.right = self.getTree(preorder,inorder[idx+1:])
            return root

if __name__ == "__main__":
    s = Solution()
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    print(s.buildTree(preorder, inorder))
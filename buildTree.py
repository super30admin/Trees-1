#The simple way to do this is to check for root and left right array from inorder and preeorder reespectiveely.
#Time Complexity: O(n)
#Space Complexity: O(h)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = 0
    def buildTree(self,inorder,preorder):
        if len(preorder)==0 or len(inorder)==0:
            return None
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1
        for i in range(len(inorder)):
            if (inorder[i] == rootVal):
                rootIdx = i
        
        preLeft = preorder[1:rootIdx+1]
        preRight = preorder[rootIdx+1:len(preorder)-1]
        inLeft = inorder[0:rootIdx]
        inRight = inorder[rootIdx+1:len(inorder)]
        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)
        return root

n1 = TreeNode(5)
n2 = TreeNode(3)
n3 = TreeNode(6)
n1.left = n2
n1.right = n3
s = Solution()
s.buildTree(n1)
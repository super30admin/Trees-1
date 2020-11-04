# In the revious approach, I used the stack but here I use the inbuild recursion stack to chieve the same.
# Time Complexity: O(n)
# Space Complexity: O(h) #at one point of time only h nodes in stack 
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        st = list()
        prev= None
        self.inorder(root,prev)

    def inorder(self,root:TreeNode,prev):
        if root is None:
            return True
        self.inorder(root.left,prev)
        if (prev is not None and prev.val>=root.val):
            return False
        prev= root
        self.inorder(root.right,prev)

n1 = TreeNode(5)
n2 = TreeNode(3)
n3 = TreeNode(6)
n1.left = n2
n1.right = n3
s = Solution()
s.isValidBST(n1)
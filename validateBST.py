
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        q = []
        prev = - float('inf')
        while q or root:
            if root:
                q.append(root)
                root = root.left
            else:
                curr = q.pop()
                if prev < curr.val:
                    prev = curr.val
                else:
                    return False
                root = curr.right
        return True
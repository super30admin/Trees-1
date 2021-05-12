# Definition for a binary tree node.
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # def isValidBST(self, root: TreeNode) -> bool:
    #     stack =[]
    #     prev=None
    #     while root or stack:
    #         while root is not None:
    #             stack.append(root)
    #             root=root.left
    #             print(root)
    #         print(root)
    #
    #         root=stack.pop()
    #
    #         if prev and prev.val>root.val:
    #             return False
    #         prev = root
    #
    #         print(root.val)
    #         root=root.right
    #     return True
    def isvalidrecBST(self,root: TreeNode) -> None:
        isValid=True
        isValid=self.isValidBST(root=root)
        return isValid


    ptr=None
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        self.isValidBST(root.left)
        print(root.val)
        if self.ptr is not None and self.ptr.val > root.val:
            return False
        self.ptr=root
        return  self.isValidBST(root.right)





if __name__ == '__main__':

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    root.right.left.left = TreeNode(7)
    root.right.left.right = TreeNode(8)

    print(Solution().isValidBST(root=root))


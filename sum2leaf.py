# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    result=0
    def sumNumbers(self, root: TreeNode) -> int:
        stack=[]
        currentSum,result=0, 0

        while root is not None or len(stack) > 0:
            while root:
                currentSum=currentSum*10+root.val
                stack.append((root, currentSum))
                root=root.left
            root,currentSum=stack.pop()
            if root.left is None and root.left is None:
                result= result+currentSum
            root=root.right

        return result
    def callrec(self,root:TreeNode):
        currentsum=0
        self.sumNumbers(root,currentsum)

    def sumrecNumbers(self,root:TreeNode, currentsum :int) -> int:

        currentsum=currentsum*10+root.val
        self.sumNumbers(root.left,currentsum)
        if root.left is None and root.right is None:
            self.result=self.result+currentsum
        self.sumNumbers(root.right,currentsum)




if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    root.right.left.left = TreeNode(7)
    root.right.left.right = TreeNode(8)

    print(Solution().sumNumbers())

#Time complexity : O(N)
#Space Complexity :O(H) h-> stands for height of the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True
        stack =[]
        prev=None
        while root !=None or len(stack)>0:
            while root != None:
                stack.append(root)
                root=root.left
            root=stack.pop()
            if prev is not None and root.val<=prev:
                return False
            print(root.val)
            prev=root.val
            root=root.right

        return True     
        
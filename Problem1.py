# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# doing inorder travesal and checking if it is sorted or not
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        a = self.inOrder(root,[])
        b = Counter(a)
        for i in b:
            if b[i] > 1:
                return False
        if a == sorted(a):
            return True
        return False
    def inOrder(self,root,result):
        if root == None:
            return [];
        a = []
        b = []
        c = []
        if root.left != None:
            a = self.inOrder(root.left,result)
        print(root.val)
        b = [root.val]
        if root.right != None:
            c = self.inOrder(root.right,result)
        return a+b+c
        
# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach







# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.max=-9999999999999
        self.flag=0
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        if self.flag==1:
            return False
        else:
            return True
    def inorder(self,root):
        if root:
            self.inorder(root.left)
            print(root.val)
            print(self.max)
            if self.max>=root.val:
                self.flag=1
                return 
            else:
                self.max=root.val
            print(root.val)
            self.inorder(root.right)
        else:
            return
        
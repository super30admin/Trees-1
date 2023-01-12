# Time Complexity :
# O(N)  - Size of the Truee

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#Do an inorder traversal of the tree and see if the inorder traversal output is sorted (strictly increasing list).
#If it is, then it is a valid BST, else false

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        sorted_list = self.inorder(root)
        print (sorted_list)
        for i in range(1,len(sorted_list)) :
            if sorted_list[i] <= sorted_list[i-1]:
                return False
        return True

    def inorder(self,root):
        if root == None:
            return []
        result = []
        result += self.inorder(root.left)
        result.append(root.val)
        result += self.inorder(root.right)
        return result

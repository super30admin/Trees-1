# Time Complexity : O(N) //We are recursively traversing the tree till N nodes in trees
#  Space Complexity : O(H) //The recursive stack  used
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        #Declarre list containing the values to pass our helper function
        values = []
        self.helper(root, values)
        #Validate if it is BST if the values on the left are larger than the right
        for i in range(1, len(values)):
            if values[i-1] >= values[i]:
                return False
        return True
    
    #Helper function to traverse the tree in-order
    def helper(self, root, values):
        if root is None:
                return
        self.helper(root.left, values)
        values.append(root.val)
        self.helper(root.right, values)
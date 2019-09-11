# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.isvalidBool(root, None, None)

    def isvalidBool(self, root, minimum, maximum):
        if root == None:
            return True
        elif (minimum != None and minimum >= root.val) or (maximum != None and maximum <= root.val):
            return False
        else:
            (self.isvalidBool(root.left, minimum, root.val)) and (self.isvalidBool(root.right, root.val, maximum))

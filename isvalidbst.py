# time complextiy: o(n)
# leetcode: accepted
# explainatin: since it is a binarry tree, the left subtree can have values ranging
# from (-infintiy, root.val), beacse the left subtree should always be smaller than the root valuw and
# the right subtree can have values ranging from (roor.val,+ infinity) . right subtree should be greater than the root value.
# We check these conditions for every node recursively
# no doubts

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def isvalidBool(root, minimum, maximum):
            if root == None:
                return True
            elif (minimum != None and minimum >= root.val) or (maximum != None and maximum <= root.val):
                return False
            else:
                return (isvalidBool(root.left, minimum, root.val) and isvalidBool(root.right, root.val, maximum))

        return isvalidBool(root, None, None)
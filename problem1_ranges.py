# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        def inorder(root, minimum, maximum):
            if root == None:
                return True

            if maximum != float('inf') and root.val >= maximum: 
                return False 
            if minimum != float('-inf') and root.val <= minimum:
                return False
            
            
            newmax = root.val
            case1 = inorder(root.left, minimum, newmax)
            newmin = root.val
            case2 = inorder(root.right, newmin, maximum)

            return (case1 and case2)

        
        
        return inorder(root, float('-inf'), float('inf'))
        
# Time complexity is O(n) where n is number of nodes
# Space complexity is O(h) where h is height of the tree
# recursion for checking range of element at each node
# let's take -inf < node.val < inf for left values , keep recurisvely changing the left boundary
# for right subtree , keep recursively changing the right boundary 



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def valid(node,left,right):
            if not node :
                return True
            if not (node.val < right and node.val > left):
                return False
            
            return (valid(node.left,left,node.val) and
            valid(node.right,node.val,right))
        
        return valid(root,float("-inf"),float("inf"))
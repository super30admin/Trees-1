#Time Complexity: O(n)
#Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def validate(root, maxi, mini):
                if root==None:
                    return True
                elif (mini!=None and root.val<=mini) or (maxi!=None and root.val>=maxi):
                    return False
                return validate(root.left,root.val,mini) and validate(root.right,maxi,root.val)
        return validate(root, None, None)
            
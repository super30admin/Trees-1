'''
Time Complexity: O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def inorder(minval, root, maxval):
            if(not root):
                return True
            if(root.val<=minval or root.val>=maxval):
                return False
            l_v = inorder(minval, root.left, root.val)
            r_v = inorder(root.val, root.right, maxval)
            # if(l_v==-1 or r_v==-1):
            #     return 0
            return l_v and r_v
        return inorder(float("-inf"), root, float("inf"))
        
            

            
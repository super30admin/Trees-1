#Time complexity: O(n)   
#Space complexity: O(h) , worst is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        self.result,self.prev = True,None
        if root is None:
            return True
        #Solution 1
        # boolean return in recursion
        def helper(root):
            #base 
            if root is None:
                return True
            if helper(root.left) is False:
                return False

            #logic
            if self.prev is not None and self.prev.val >= root.val:
                return False
            self.prev = root
            return helper(root.right)
        return helper(root)
        # Solution 2
    #normal working with void pattern
#         def helper(root):
#             #base condition
#             if root is None:
#                 return
#             #logic
#             helper(root.left)
#             if self.prev is not None and self.prev.val>=root.val:
#                 self.result = False
#                 return
#             self.prev = root
#             helper(root.right)
        
#         helper(root)    
#         return self.result
# Solution 3
#behind the scenes recursion
#         st = []
#         prev = None
#         res = True
#         while root is not None or len(st) != 0:
#             while root is not None:
#                 st.append(root)
#                 root = root.left
#             root = st.pop()
#             if prev is not None and prev.val>=root.val:
#                 return False
                
#             prev = root
#             root = root.right
#         return True
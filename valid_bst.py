'''
Time complexity :O(N)
Space complexity :O(1)
'''


class Solution:
    def isValidBST(self, root):
        if not root:
            return True
        stack = [(root, float('-inf'), float('inf')), ] 
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            val = root.val
            if val <= lower or val >= upper:
                return False
            stack.append((root.right, val, upper))
            stack.append((root.left, lower, val))
        return True 

'''Recursive solution'''

# class Solution:
#     def isValidBST(self, root):
#         def helper(node, lower = float('-inf'), upper = float('inf')):
#             if not node:
#                 return True
            
#             val = node.val
#             if val <= lower or val >= upper:
#                 return False

#             if not helper(node.right, val, upper):
#                 return False
#             if not helper(node.left, lower, val):
#                 return False
#             return True

#         return helper(root)
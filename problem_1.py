# TC: O(n)
# SC: (h) where h is height for tree- stack space 

import sys
def isValidBST(root):
    def helper(root, min, max):
        if not root:
            return True
        if root.val >= max or root.val <= min:
            return False
        return helper(root.left, min, root.val) and helper(root.right, root.val, max)
    
    
    return helper(root, -sys.maxsize - 1, sys.maxsize)


def isValidBST_void(root):
    is_valid = True
    def helper(root, min_val, max_val):
        nonlocal is_valid
        if not root or not is_valid: return
        print(min_val, root.val, max_val)
        if root.val <= min_val or root.val >= max_val:
            is_valid = False
            return
        helper(root.left, min_val, root.val)
        helper(root.right, root.val, max_val)


    helper(root.left, float("-inf"), root.val) 
    helper(root.right, root.val, float("inf"))
    return is_valid
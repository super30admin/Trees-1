# Time Complexity: O(n)
# Space Complexity: O(h)

# DFS - Inorder Traversal - Recursive Approach
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(root):
        if root is None:
            return True
        
        isValid = True
        inorder(root)

        return isValid

    def inorder(root):
        # base
        if root is None:
            return 

        # logic
        inorder(root.left)
        if prev.val >= root.val:
            isValid = False
            return
        #print(root.val)
        prev = root
        inorder(root.right)
 


# Method - 2
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(root):
        if root is None:
            return True
        
        return helper(root, null, null)


    def helper(root, min, max):
        # base
        if root is None:
            return True

        # logic
        case1 = helper(root.left, min, root.val)
        case2 = helper(root.left, root.val, max)

        if min is not None and root.val <= min:
            return False
        if max is not None and root.val >= max:
            return False

        return case1 and case2

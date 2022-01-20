# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
        s = []
        prev = None
        while(s or root!=None):
            while(root != None):
                s.append(root)  
                root = root.left
            root = s.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            # print(root.val)
            root = root.right
        return True


# T.C => O(H) height of the tree
# S.C => O(N) We traversed every element in the root
# Approach => This is iterative approach, where we are append all the values that are left of the root. 
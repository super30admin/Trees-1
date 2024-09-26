# Time Complexity: O(N)
# Space Complexity: O(H), where H is height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    prev = None
    isvalid = False
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.isvalid = True
        self.inorder(root)
        return self.isvalid
    
    def inorder(self, root) -> None:
        if root == None:
            return
        if self.isvalid:
            self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            self.isvalid = False
            return
        self.prev = root
        if self.isvalid:
            self.inorder(root.right)


#############################################################

# Time Complexity: O(N)
# Space Complexity: O(H), where H is height


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import sys

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)
    
    def helper(self, root, mi, ma):
        
        #base case
        if root == None:
            return True
        
        if mi != None and root.val <= mi:
            return False
        
        if ma != None and root.val >= ma:
            return False
        
        print(root.val)
        #Logic
        
        return self.helper(root.left, mi, root.val) and self.helper(root.right, root.val, ma)


#############################################################

# Time Complexity: O(N)
# Space Complexity: O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        st = list()
        prev = None
        while root != None or len(st) != 0:
            # inorder
            while root != None:
                st.append(root)
                root = root.left
            root = st.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
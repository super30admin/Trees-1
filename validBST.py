"""
Check if given Tree is valid BST.

All of the approaches below have same time and space complexity.
Time = O(n), n = number of nodes given in Tree
Space = constant = O(n), n = number of nodes given in Tree
Successfully excecuted on leetcode

Approach 1(Inorder) ---
1. Given a Tree, get the inorder traversal list.
2. If the inorder traversal is sorted, return True.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class ValidBST:
    def isValidBST(self, root: TreeNode) -> bool:     
        if not root:
            return True
        ans = []
        self.inOrder(root, ans) # -- time = O(N), space = O(N)
        
        for i in range(1, len(ans)): # -- time = O(N), space = O(1)
            if ans[i-1] >= ans[i]:
                return False

        return True

    def inOrder(self, root, ans): 
        stack = []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                return ans
            node = stack.pop()
            ans.append(node.val)
            root = node.right
            
"""
Approach 2(Iteration) --
1. Create a stack to compare each root with left and right childern 
2. Check for left and right children till leaf node
"""

class ValidBST:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = [(root,float('-inf'),float('inf'))]
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            if root.val <= lower or root.val >= upper:
                return False
            stack.append((root.left,lower,root.val))
            stack.append((root.right,root.val,upper))
        return True
    
            
"""
Approach 3(Recursion) --
1. Create a stack to compare each root with left and right childern 
2. Check for left and right children till leaf node
"""
class ValidBST:
    def isValidBST(self, root: TreeNode) -> bool:
         return self.recurse(root)
    def recurse(root, lower = float('-inf'), upper= float('inf')):        
        if not root:
            return True
        if root.val <= lower or root.val >= upper:
            return False
        if not self.recurse(root.right,root.val,upper):
            return False
        if not self.recurse(root.left,lower,root.val):
            return False
        return True

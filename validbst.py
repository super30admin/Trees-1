# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#time complexity:o(n) where n is num of elements in bin tree
#space complexity:o(h) h is height of bin tree bec we store atmost h elements in the tree
#passed all cases on LeetCode:
#difficulty faced:
# comments:in the code
#https://leetcode.com/problems/validate-binary-search-tree/description/
class Solution:
    def isValidBST(self, root: 'Optional[TreeNode]') -> bool:
        
        self.prev = -math.inf
        
        def inorder(root):
            if not root:
                return True
            
            #this is an optimized approach of the solution and if we get a false from left stack we return false
            if not inorder(root.left):
                return False
     #after the leftmost traversal root moves to parent and so we compare it with prev which is still left child and return false here itself       
            if root.val <= self.prev:
                return False
            #update the prev to current root
            self.prev = root.val
            return inorder(root.right)
        
        return inorder(root)
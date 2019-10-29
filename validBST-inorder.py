# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time complexity - O(n)
#Space complexity - O(n) because of stack
#Explanation - Inorder traversal approach using stack

class Solution:
    	def isValidBST(self, root):
            if root == None:
                return True
            prev = None
            stack = []
            while(root != None or len(stack) > 0):
                while(root != None):
                    stack.append(root)
                    root = root.left
                root = stack.pop()
                if prev != None and root.val <= prev.val:
                    return False
                prev = root
            return True
                root = root.right

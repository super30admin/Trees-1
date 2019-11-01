# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Optimal solution accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(n)because of stack creation


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
				root = root.right
            return True
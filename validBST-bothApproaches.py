# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


"""Approach: Inorder traversal Iterative solution"""

#Accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(n)because of recursive stack in memory
#Approach - First we need to push all the left node elements into the stack and then you need to pop, using current and previous values we have to check the binary tree.


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


"""Approach: Recursive solution with Max and Min"""

#Accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(n)because of recursive stack in memory
#Approach - For the left node, update maximum value and minimum value remains same. For right node, minimum value is updated and maximum value remains same. 


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root, mini, maxi):
            #Base Case - First thing we do in a recursive solution is to write the base case
            if root == None:
                return True
            if mini != None and root.val <= mini:
                return False
            if maxi != None and root.val >= maxi:
                return False
            return helper(root.left, mini, root.val) and helper(root.right, root.val, maxi)
        return helper(root, None, None)
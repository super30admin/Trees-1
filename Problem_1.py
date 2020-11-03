"""
Time Complexity : O(n) 
Space Complexity : O(h) as max number of values inside the stack will be equal to height of the tree
unless the tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I have put in here both recursive and iterative code. Here, we will maintain a previous pointer that can keep 
a track of what node we traversed last. If the value of previous is greater than current node, then it is
not a BST as we are traversing in inorder fashion, left->root->right.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        self.prev = TreeNode(None)
        return self.helper(root)

    def helper(self, root):
        if not root:
            return True
        if not self.helper(root.left):
            return False
        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.helper(root.right)

        """
        if not root:
            return True
        prev=TreeNode(None)
        stack=[]
        while root!=None or len(stack)>0:
            while root!=None:
                stack.append(root)
                root=root.left
            root=stack.pop()
            if prev!=None and prev.val>=root.val:
                return False
            prev=root
            root=root.right
        return True
        """

"""
// Time Complexity : O(n) 
// Space Complexity : O(h) //max only height corresponding nodes will be there in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Brute force - Inorder traversal sorted or no - O(n)
General idea
Idea is that current element down the tree should be less than parent 
element below root (Elements to left of root) 
We compare the parent and current node avalue by way of prev pointer(giving the right
one from the stack/rec stack)
"""

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
        #Method1 - Understanding the recursion (iteratively stack version)
        stk = []
        prev = None
        while stk or root:
            while root:
                stk.append(root)
                root = root.left
            root = stk.pop()
            if prev and prev.val >= root.val: 
                return False
            prev = root
            root = root.right
        return True
        
        #Method2 - Recursive transition
        self.prev = None
        def inorder_rec(root):
            #base
            if not root:
                return True
            #recurse left
            if not inorder_rec(root.left):
                return False
            #condition for BST
            if self.prev and self.prev.val >= root.val:
                return False
            #updating prev
            self.prev = root
            
            #recurse right
            return inorder_rec(root.right)
        return inorder_rec(root)

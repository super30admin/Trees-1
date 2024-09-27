#98. Validate Binary Search Tree
#Time Complexity : O(n) 
#Space Complexity : O(h) height of the tree
#Did this code successfully run on Leetcode : Yes
#traverse first from left of the root if not left node then return false else continue till we reach lead node. Then we pop the top of stack and assign it as root and check if prev value is less than current else return false. will continue till we reach the last element on right side
#recursive
#class Solution: 
#    pre = None
#    def inorder(self,root):
#        if not root:
#            return True
#        if not self.inorder(root.left) :
#            return False
#        if self.pre and root.val <= self.pre.val:
#                return False 
#        self.pre = root 
#        return self.inorder(root.right)
#    def isValidBST(self,root):
#        return self.inorder(root)
#iterative 
class Solution:
    def isValidBST(self,root):        
		stack = []
        pre = None 
        curr = root 
        if curr is None:
            return True
        while stack or curr:
            while curr != None:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
                #node = stack.pop()
            if pre and curr.val <= pre.val:
                return False 
            pre = curr 
            curr = curr.right 
        return True 
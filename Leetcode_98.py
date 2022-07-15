#Time Complexity: O(n) 
#Space Complexity: O(n)

class  TreeNode(object):
    def _init_(self,x):
        self.val=x
        self.left=None
        self.right= None
class Solution:
    def isValidBST(self, root):
        self.correct=True
        self.prev=float('-inf')
        self.inorder(root)
        return self.correct
    def inorder(self, node):
        if not node or not self.correct:
            return
        self.inorder(node.left)
        if  node.val<=self.prev:
            self.correct=False
            return
        self.prev=node.val
        self.inorder(node.right)
        
class Solution2(object):
    def isValidBST(self,root):
        return self.valid(root,float('inf'), float('inf'))
    def valid(self, node, lower, upper):
        if not node:
            return True
        if node.val<= lower or node.val>=upper:
            return False
        return self.valid(node.left, lower, node.val) and self.valid(node.right, node.val, upper)
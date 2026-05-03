# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        # pay attention to global vs parameter of recursion
        # prev cannot go into the recursion stack
        self.flag = True
        self.prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag
    
    # you cannot pass prev into the helper. Track what goes into the recursive stack only
    # when recursion stack unfolds, the parameters of recursion will be overwritten
    def helper(self,root):
        if root == None:
            return
        # if I got a breach, exit - can save some of the nodes
        if not self.flag:
            return
        print(root.val)
        self.helper(root.left)
        if self.prev != None and root.val <= self.prev.val:
            self.flag = False
            # even if you add a return here, all recursive calls are still completed because
            # return returns to the same place from where we called it
            # whatever goes into the recursion stack will come out
        
        self.prev = root
        self.helper(root.right)


# can also use range:

class Solution:
    def __init__(self):
        # pay attention to global vs local scope. 
        # prev cannot go into the recursion stack
        self.flag = True
        self.prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root,None,None)
        return self.flag

    def helper(self,root,min,max):
        if root is None:
            return
        
        self.helper(root.left,min,root.val)
        if max != None and root.val >=max:
            self.flag=False
        if min != None and root.val <= min:
            self.flag=False
        self.helper(root.right,root.val,max)
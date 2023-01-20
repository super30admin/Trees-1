TC-0(N)
SC-O(N) #recursive stack

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    currSum = 0
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.__helper(root,0)
        return self.currSum

    def __helper(self, root, currNum):
        #base condition
        if root == None:
            return
        #logic
        currNum = currNum*10+root.val
        if root.left==None and root.right==None:
            self.currSum = currNum + self.currSum


        self.__helper(root.left,currNum)
        self.__helper(root.right,currNum)
        
        
# time complexity : O(n)
# space complexity: O(h)


# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class Solution:

# Inorder using recursion ------>
#  maintain previous value 
#  intially it will be null as iteration starts with leaf node of left node
#  set that node(left node) to previous and compare with root
#  if it will smaller than root than set root to previous and compare updated root to the right node otherwise return false
#  if updated previous is smaller than right node than do that process again or otherwise return false
#  make that node to prev and compare with root.....
    def __init__(self) -> None:
        self.prev = None
        self.flag = True

    def isValidBST(self, root) -> bool:
        root = TreeNode()
        self.inOrder(root)
        return self.flag

    def inOrder(self, root):
        if root == None:
            return 
        self.inOrder(root.left)
            
        if self.prev != None and root.val <= self.prev.val:
            self.flag =  False
        self.prev = root
        self.inOrder(root.right)
        return self.flag
        #  here left recursion is completed, so set root to the previous and do right recursion
        


# Inorder using iteration ------>
#  same thing but using iteration instead of recursion
    def isValidBST2(self, root):
        root = TreeNode()
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


# min & max ------>
    def isValidBST3(self, root):
        root =TreeNode()
        return self.helper3(root, None, None)
    
    def helper3(self, root, minVal, maxVal):
        if root == None:
            return True
        if minVal != None and root.val <= minVal:
            return False
        if maxVal != None and root.val >= maxVal:
            return False
        return self.helper3(root.left, minVal, root.val) and self.helper3(root.right, root.val, maxVal)



obj = Solution()
print(obj.isValidBST([1,2,3]))
print(obj.isValidBST2([1,2,3]))
print(obj.isValidBST3([1,2,3]))




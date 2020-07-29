#Time Complexity : O(N)
#Space Complexity: O(H)
#Yes it ran on leetcode

class Solution(object):
    def isValidBST(self, root):
        if root == None:
            return True
        return self.inorder(root, float('-inf'), float('inf'))

    def inorder(self, root, minimum, maximum):
        if root == None:
            return True

        validleft = self.inorder(root.left, minimum, root.val)
        validright = self.inorder(root.right, root.val, maximum)
        if root.val <= minimum or root.val >= maximum:
            return False
        return validleft and validright
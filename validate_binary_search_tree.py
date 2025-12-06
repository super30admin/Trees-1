# https://leetcode.com/problems/validate-binary-search-tree/

# Time Complexity- O(n) Space Complexity- O(h) 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def __init__(self):
        # defining the flag and prev value
        self.flag = True
        self.prev = None

    # this method checks if the tree is valid
    def isValidBST(self, root):
        # calls the recursive helper method
        self.helper(root)
        return self.flag
    
    def helper(self, root):
        # if the root is none nothing to check
        # base case - it must be there that terminate recursion otherwise it goes into infinite loop
        if root is None:
            # below 'return' means return to the place from where call is made
            # return would take you to the same place from wherever the call is made
            return
        # processing for the left root when flag is true
        if self.flag:
            # this is the 'recursion' means function calling itself which is at line number 16
            self.helper(root.left)

        # check the left subtree if the value is greater than the node then it's not valid BST so turn the Flag as False
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        # store the recently visited node
        self.prev = root
        # checking the right subtree only if the left subtree is correct using the flag condition (by default 'True')
        if self.flag:
            self.helper(root.right)

root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)

solution = Solution()
result = solution.isValidBST(root)   
print(result)
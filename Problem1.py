# Trees-1

## Problem 1

# https://leetcode.com/problems/validate-binary-search-tree/

#Approach
# set a flaf to True. In helper function, traverse the tree in inorder traversal. If the treee is a BST, the value of the nodes would always be sorted using inorder traversal
# Using this, recursively call the left child setting min to -inf and max to curr root val till we reach the leaf node. Similarly, call the right children with min set to root value and max set to inf
# For each node check if root val is less than min and more than max. If yes, set flag to False. Return flag

# Time Complexity: O(n)
# Space Complexity: O(h) h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def helper(self, root, min, max):
        #base
        if root == None:
            return

        #logic

        self.helper(root.left,min,root.val)

        if (min != None and root.val <= min) or (max!=None and root.val>=max):
            self.flag = False
            return 

        self.helper(root.right,root.val,max)


    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root,None,None)
        return self.flag

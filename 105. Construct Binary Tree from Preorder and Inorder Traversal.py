# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took a long time wrapping around the recursion.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    '''
    - Inorder values are stored in a dictionary to access index of each values in O(1)
    - Preorder will have root for each iteration, so a pointer is assigned for current root
    - a helper function recurses over each subtree to build it up. start, end pointers used to do processing in place
    '''
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        dict = {}
        pointer = 0
        for index, value in enumerate(inorder):
            dict[value] = index
        

    
        def helper(preorder, start, end):
            nonlocal dict, pointer
            if start > end :
                return None
            root = TreeNode(preorder[pointer])
            pointer += 1
            indx = dict[root.val]
            root.left = helper(preorder, start, indx - 1)
            root.right = helper(preorder, indx + 1, end)
            return root
        
        return helper(preorder, 0, len(inorder) - 1)
            



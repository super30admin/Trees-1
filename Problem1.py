# Problem 1: https://leetcode.com/problems/validate-binary-search-tree/


#Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack=[]
        prev = None

        if root is None:
            return True
        while root or stack:
            while root:
                stack.append(root)
                root=root.left
                # print(root)
            root=stack.pop()
            if prev and root.val <= prev.val:
                return False
            prev=root
            root=root.right
            # print(root)
            # print('prev',prev)
        return True
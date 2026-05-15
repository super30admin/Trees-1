# Time Complexity : O(n)
# Space complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Missed edge case and missed to have index variable at global level took some time to realize the mistake.

# Your code here along with comments explaining your approach
# Precompute a hash map of the inorder array values to their indices so that locating any root node and divide the remaining elements into left and right subtrees will be in O(1) time
# Use a global tracking pointer (self.index) to get the next root node from the preorder array,move forward by one step every time a node is created.
# Recursively build the left and right subtrees using start and end pointers.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """

        self.index = 0
        inorder_map = {}

        for i in range(len(inorder)):
            val = inorder[i]
            inorder_map[val] = i

        return self.helper(preorder, 0, len(inorder)-1, inorder_map)


    def helper(self, preorder, start, end, inorder_map):
        if start > end:
            return None

        root_val = preorder[self.index]
        self.index += 1

        root = TreeNode(root_val)

        root_idx = inorder_map[root_val]
        root.left = self.helper(preorder, start, root_idx - 1, inorder_map)
        root.right = self.helper(preorder, root_idx + 1, end, inorder_map)

        return root
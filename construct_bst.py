# Time Complexity : O(n)
# Space Complexity : O(n) because of the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we create a binary tree from the inorder and preorder traversal of the tree by going through the preorder traversal. 
The first number in the pre-order traversal will always be the root node. After which the builder function is called recursively 
to create the left side first and then the right side by passing in the values on the either side of the root node in the inorder traversal.
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.hashmap = {}
        for index, value in enumerate(inorder):
            self.hashmap[value] = index

        self.preorder_index = 0
        self.preorder = preorder

        return self.builder(0, len(preorder) - 1)

    def builder(self, left, right):
        if left > right: return None

        root = TreeNode(self.preorder[self.preorder_index])
        self.preorder_index += 1

        root.left = self.builder(left, self.hashmap[root.val] - 1)
        root.right = self.builder(self.hashmap[root.val] + 1, right)

        return root




        
        
#https://leetcode.com/problems/validate-binary-search-tree/
# Time Complexity: O(n), we visit every node exactly once
# Space Complexity: O(h), h is the height of the tree, due to recursion stack
# Approach: do an in-order traversal (left, current, right). 
#In a valid BST, this visits values in strictly increasing order, so we just compare each node to the one visited right before it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
       

        self.flag = True      # assume valid until we find proof otherwise
        self.prev = None      # tracks the previously visited node in the in-order walk

        def helper(currentNode):
            # base case: we've gone past a leaf, nothing here to check
            if currentNode is None:
                return

            # step 1: fully process the entire left side first
            helper(currentNode.left)

            # step 2: now check the current node against the last one we visited
            if self.prev is not None and self.prev.val >= currentNode.val:
                self.flag = False

            # step 3: this node is now "the previous one" for whatever comes next
            self.prev = currentNode

            # step 4: now process the entire right side
            helper(currentNode.right)

        helper(root)        # kick off the traversal starting at the actual tree root
        return self.flag    # report whether any violation was found
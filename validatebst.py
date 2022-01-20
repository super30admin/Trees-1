# // Time Complexity : O(n)
# // Space Complexity : O(h) -> in the worst case this will be O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# First we determine the bounds for each node. Per the rules of a BST, if the left bound greater that the root you are at or the right
# bound is less than the node you are at then we return False. We recurse left and right subtrees with the bounds. Left subtree is bounded in the left
# previous left bound and the right is bounded by the root node of that subtree. The right subtree is bounded in the left by the root node of its subtree and
# in the right by the previous right bound.
class Solution(object):

    def isValidBST(self, root):
        return self.dfs(root, float("-inf"), float("inf"))

    def dfs(self, node, left_bound, right_bound):
        if node == None:
            return True
        if not (left_bound < node.val < right_bound):
            return False
        left = self.dfs(node.left, left_bound, node.val)
        right = self.dfs(node.right, node.val, right_bound)
        return left and right
"""
TC: O(N) {at worst case we have to travel for the entire number of elements}
SC: O(N) {if we consider the stack space used by recursion its O(N) but if not its O(1)}

Approach:

We know that each node would fall in a range of min and max, and for starters, the root node would be anywhere between min int val
to max int val. Hence we start with that and for every element (either left or right), we update our range in the parameter of the recusive helper
function.

Let's say, we move towards left, here the min remains the same but the max now becomes the val of parent, also for right, the max remains the same
but the min now becomes the parent's val. We take this into account and for every recursive call update the params of the function.

If at any point, we encounter a breach where the node's val does not fall in the given range, we set the global flag as false, and eventually return that.

The problem ran successfully on Leetcode.
"""

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def helper(self, node, mini, maxi):
        if not node:
            return
        
        if not mini<node.val<maxi:
            self.flag = False
            return
        
        
        self.helper(node.left, mini, node.val)
        self.helper(node.right, node.val, maxi)



    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root, float("-inf"), float("inf"))
        return self.flag
# Time Complexity : O(n) [n = number of elements in preorder list]
# Space Complexity : O(n) [n = number of elements in preorder list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Problem approach
# 1. The inorder traversal for a BST is sorted
# 2. Save the last node value in a variable and compare it with curr node value
# 3. Return False if the curr node value is lesser than prev node value
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        curr = root
        stack = []
        prev_val = None
        while curr or stack:
            if curr:
                stack.append(curr)
                while curr.left:
                    stack.append(curr.left)
                    curr = curr.left
            curr = stack.pop()
            if  prev_val is None: # True, if it is the first node
                prev_val = curr.val
            else:
                if curr.val <= prev_val: # Return false as soon as the condition breaks
                    return False
                else:
                    prev_val =curr.val # Update the previous value with curr_val after comparison
            curr = curr.right
        return True
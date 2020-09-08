
# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = []
        prev = None

        while stack and root:
            while root:
                stack.append(root)
                root = root.left

            curr = stack.pop()

            if prev != None and prev.val >= curr.val:
                return False
            
            prev = curr

            root = curr.right
        return True
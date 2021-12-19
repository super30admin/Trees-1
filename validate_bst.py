'''
// Time Complexity : O(N)
// Space Complexity : O(h), height of the trees, at worse can be N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

Approach: inorder traversal and check
TC: O(N), SC: O(h), height of the trees, at worse can be N
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None
        
        while len(stack) != 0 or root != None:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and root.val <= prev.val:
                return False
            prev = root
            root = root.right
        return True
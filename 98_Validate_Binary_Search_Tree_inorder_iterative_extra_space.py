# Time Complexity : O(n) [n = number of elements in preorder list]
# Space Complexity : O(n) [n = number of elements in preorder list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Problem approach
# 1. The inorder traversal for a BST is sorted
# 2. Find and inorder and save all the values in a list
# 3. Return True if the list is sorted else False
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        inorder = []
        curr = root
        stack = []
        
        while curr or stack:
            if curr:
                stack.append(curr)
                while curr.left:
                    stack.append(curr.left)
                    curr = curr.left
            curr = stack.pop()
            inorder.append(curr.val)
            curr = curr.right
        for i in range(1,len(inorder)):
            if inorder[i] <= inorder[i-1]:
                return False
        return True
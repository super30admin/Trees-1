## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

#Approach
# The first element in preorder list will always be the root. Find the same element in the inoder list. All elements to the left would be its left children and right would be right children
# Find the length of element to the left of root node in inorder list and use that length to find the left children the preorder and similarly for right children
# Recrusively call the left and right children and for left pass preLeft,inLeft list and for right side pass preRight,inRight

# Time Complexity: O(n**2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return

        rootval = preorder[0]
        rootidx = -1
        for i in range(len(inorder)):
            if rootval == inorder[i]:
                rootidx = i
        
        root = TreeNode(rootval)

        inLeft = inorder[:rootidx]
        inRight = inorder[rootidx+1:]
        preLeft = preorder[1:len(inLeft)+1]
        preRight = preorder[len(inLeft)+1:]

        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)

        return root
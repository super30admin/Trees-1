# // Time Complexity : O(n)
# // Space Complexity : O(h) -> in the worst case this will be O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# We first build a hashmap mappung the inorder values to its index. This is to obtain the root index in teh inorder array
# in constant time. We start the recursion two pointers at the end of the inorder array. we select the root value from the preorder arr
# That value is mapped to the index via the hashmap we initially created.
#That index is taken as the bounds to recusrively divide the inorder arr left and right

class Solution(object):
    def buildTree(self, preorder, inorder):
        self.map = {}
        self.index = 0
        for idx in range(len(inorder)):
            self.map[inorder[idx]] = idx
        return self.helper(preorder, inorder, 0, len(inorder) - 1)
    def helper(preorder, inorder, start, end):
        if start > end:
            return None
        rootval = preorder[self.index]
        root = TreeNode(rootval)
        inorderIdx = self.map[rootval]
        self.index += 1
        root.left = self.helper(preorder, inorder, start, inorderIdx - 1)
        root.right = self.helper(preorder, inorder,  inorderIdx + 1, end)
        return root
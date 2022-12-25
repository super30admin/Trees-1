# // Time Complexity : O (n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
## We use preorder to get the root of the tree and inorder to find the left and right elements of our root. 1st element
## of preorder is root so we have a global index that keeps on increasing and we get the root element from this. 
## we also have a hashmap which maps the val and idx of inorder to make search O(1). so once we get the root we 
## compute its left and right recursively. for left we go from start to hashmap[root.val]-1 and for right we go from
##hashmap[root.val]+1 to end

class solution:
    inorderHashmap = {}
    preorderIdx = 0
    def build(self, preorder, inorder):
        for idx, val in enumerate(inorder):
            self.inorderHashmap[val]= idx
        return self.helper(preorder, inorder, 0, len(preorder)-1)

    def helper(self, preorder, inorder, start, end):

        if start>end:
            return 

        root_val = preorder[self.preorderIdx]
        root = TreeNode(root_val)

        root.left = self.helper(preorder, inorder, start, self.inorderHashmap[root_val]-1)
        root.right = self.helper(preorder, inorder, self.inorderHashmap[root_val]+1, end)

        return root
    

    
# time complexity: O(n)
# Space Complexity: O(n)
# Approach:
# store the indexes of elements of inorder in a hashmap so that we can find the left subtree and right subtree indexes in O(1)
# traverse the preorder array, create a node for it and find the left and right subtree indexes for that node
# pass these left and right indexes to recursion

class Solution:
    hashmap = dict()
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            self.hashmap[inorder[i]]=i
        return self.helper(preorder, inorder, 0, len(inorder)-1)
    def helper(self,preorder, inorder, start, end):
        #base
        if start > end:
            return None
        #logic
        rootidx = self.hashmap[preorder[self.idx]]
        root = TreeNode(preorder[self.idx])
        self.idx = self.idx+1
        root.left = self.helper(preorder, inorder, start, rootidx-1)
        root.right = self.helper(preorder, inorder, rootidx+1, end)
        return root
    
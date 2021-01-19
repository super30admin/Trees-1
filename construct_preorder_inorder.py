# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use preorder list to find the root and inorder to find left and right subtrees recursively

# Your code here along with comments explaining your approach

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.mapping = defaultdict(lambda:0)
        self.idx = 0
        for i in range(len(inorder)):
            self.mapping[inorder[i]] = i
          
        return self.helper(preorder, 0, len(preorder)-1)
    
    def helper(self, preorder, start, end):
        if start > end:
            return None
        
        
        root_element = preorder[self.idx]
        root_index = self.mapping[root_element]
        self.idx += 1
        node = TreeNode(val=root_element)
        node.left = self.helper(preorder, start, root_index-1)
        node.right = self.helper(preorder, root_index+1, end)

        return node
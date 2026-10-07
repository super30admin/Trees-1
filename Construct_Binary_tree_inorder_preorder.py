# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Recursive Approach. Since preorder traversal is root, left, right, every recursion we get the first element from preorder
# Then get the index of root from inorder so everything before the index is left subtree and everything after the index is right subtree


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode | None:
        if not preorder:
            return None
        if not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root
#Time - O(N2)
#Space - O(N2)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode | None:
        if not preorder:
            return None
        self.idx = 0
        inorder_map = {}
        for i in range(len(inorder)):
            inorder_map[inorder[i]] = i
        def helper(start, end):
            if start > end:
                return None
            root_val = preorder[self.idx]
            self.idx += 1
            index = inorder_map[root_val]
            root = TreeNode(root_val)
            root.left = helper(start, index-1)
            root.right = helper(index+1, end)
            return root
        return helper(0, len(inorder)-1)
    

